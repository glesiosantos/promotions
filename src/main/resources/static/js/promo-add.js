// funcao para capturar as metas tags
$('#linkPromocao').on('change', function(){
    var url = $(this).val();

    if(url.length > 7) {
        $.ajax({
            method: "POST",
            url: "/metas/info?url="+url,
            cache: false,
            beforeSend: function(){
                $('#alert').removeClass('alert alert-danger').text('')
                $('#titulo').val('')
                $('#site').text('')
                $('#loader-img').addClass('loader')
//                $('#linkImagem').remove()
            },
            success: function(data) {
                console.log(data)
                $('#titulo').val(data.title)
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