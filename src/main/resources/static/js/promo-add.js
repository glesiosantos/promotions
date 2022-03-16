$('#form-add-promo').submit(function(event){
    event.preventDefault() // evita padrão do submit seja chamado
    let promotions = {}
    promotions.linkPromotion = $('#linkPromocao').val()
    promotions.description =  $('#descricao').val()
    promotions.title = $('#title').val()
    promotions.category = $('#category').val()
    promotions.price= $('#price').val()
    promotions.imageLink = $('#linkImagem').attr('src')
    promotions.sitePromotion = $('#site').text()
    console.log('promotions ', promotions)

    $.ajax({
        method: 'POST',
        url: '/promotions/save',
        data: promotions,
        beforeSend: function(){
            // removendo as messages
            $('span').closest('.error-span').remove()

            // removendo as bordas vermelhas
            $('#category').removeClass('is-invalid')
            $('#price').removeClass('is-invalid')
            $('#title').removeClass('is-invalid')

            //habilando o loading
//            $('#form-add-promo').hide();
//            $('#loader-form').addClass('loader').show()
        },
        success: function() {
            $('#form-add-promo').each(function(){
                this.reset();
            })
            $('#linkImagem').attr('src', '/images/promo-dark.png')
            $('#site').text('')

            $('#alert').addClass('alert alert-success').text('Ok! Promoção cadastrada com sucesso')
        },
        statusCode: {
            422: function(xhr) {
                console.log('status error.: ', xhr.status)
                const errors = $.parseJSON(xhr.responseText)
                $.each(errors, function(key, value){
                    console.log('***********************', key)
                    $('#'+key).addClass('is-invalid')
                    $('#error-'+key).addClass('invalid-feedback')
                            .append('<span class="error-span">'+ value +'</span>')
                })
            }
        },
        error: function(xhr){
            console.log('> error: ', xhr.responseText)
            $('#alert').addClass('alert alert-danger').text('Ops! não foi possível salvar esta promoção')
        },
    })
})

// funcao para capturar as metas tags
$('#linkPromocao').on('change', function(){
    var url = $(this).val();

    if(url.length > 7) {
        $.ajax({
            method: "POST",
            url: "/metas/info?url="+url,
            cache: false,
            beforeSend: function(){
                $('#alert').removeClass('alert alert-danger alert-success').text('')
                $('#title').val('')
                $('#site').text('')
                $('#loader-img').addClass('loader')
//                $('#linkImagem').remove()
            },
            success: function(data) {
//                console.log(data)
                $('#title').val(data.title)
                $('#site').text(data.site.replace('@',''))
                $('#linkImagem').attr("src", data.image)
                $('#loader-img').removeClass('loader')
            },
            statusCode: {
                404: function() {
                    $('#linkImagem').attr('src', '/images/promo-dark.png')
                    $('#alert').addClass("alert alert-danger").text("Nenhum informação pode ser recuperada da URL informada")
                },
                error: function() {
                    $('#linkImagem').attr('src', '/images/promo-dark.png')
                    $('#alert').addClass("alert alert-danger").text("Ops... algo deu errado, tente mais tarde")
                },
                complete: function() {
                    $('#loader-img').removeClass('loader')
                }
            }
        })
    }
})