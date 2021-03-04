$(document).ready(function () {
    post = new post();
});

class post {
    constructor() {
       /* $(document).on("click", ".link", this.getPost);*/
    }

    /*getPost(){
        var post = {}
        var id = $(this);
        var name = id[0].innerText;
        post["id"] = id.children()[0].value
        post["title"] = name
        $.ajax({
            url : "/id-post",
            contentType : "application/json;charset=UTF-8",
            type : 'post',
            async:false,
            data : JSON.stringify(post),
            success: function (data){
             /!*   $.ajax({
                    url : "/show-post/" + name,
                    contentType : "application/json;charset=UTF-8",
                    type : 'get',
                    async:false,
                    success: function (data){

                    },
                    error : function(error) {
                        console.log("ERROR: ", error);
                    }
                });*!/
            },
            error : function(error) {
                console.log("ERROR: ", error);
            }
        });
    }*/
}