
$document().ready(function () {
    $button.click(function () {

        $.ajax({
            type: POST,
            url: 'https://localhost:8080/shorten_url',
            data: JSON.stringify({
                'long_url': $("#urlInput").val()
            }),
            contentType: 'application/JSON; charset=utf-8',
            success: function (data) {
                $("#shortUrl").val(data.short_url);
            }
        });
    });
});