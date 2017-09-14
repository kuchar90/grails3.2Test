window.onload = function() {
    $('body').on('click', '#createDomainLink' , function (e) {
        e.preventDefault();
        $('#addDomainBox').addClass('locked');
        addDomain(300);
    });

    function addDomain(counter) {
        if(counter === 0){
            $('#addDomainBox').removeClass('locked');
        }else{
            $.ajax({
                url: '/test/createDomain' ,
                type: 'post',
                async: false
            }).done(function(resp) {
                $.ajax({
                    url: '/test/getDomain/' + resp.id,
                    type: 'post',
                    async: false
                }).success(function(resp) {
                    addDomain(--counter);
                }).error(function () {
                    alert('error occurred');
                });
            })
        }

    }


};