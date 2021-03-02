$(document).ready(function () {
    admin1 = new admin1();
});

class admin1 {
    constructor() {
        $(document).on("click", ".sub", this.newPost);
    }

    newPost() {
        var listElement = $('.element');
        var listParagraph = $('.element.paragraph');
        var listImage = $('.element.image');
        var title = listElement[0].value;
        var subject = listElement[1].value;
        var d = new Date();
        //var date = d.getFullYear() + "/" + d.getMonth() + "/" + d.getDate();
        var post = {};
        post["title"] = title;
        post["subject"] = subject;
        //post["date"] = date;
        //post["author_id"] = 1;
        $.ajax({
            url : "/insertpost",
            contentType : "application/json;charset=UTF-8",
            type : 'post',
            data : JSON.stringify(post),
            success : function(data) {
                for(let i = 0; i < listParagraph.length; i++){
                    var paragraph = {};
                    paragraph["content"] = listParagraph[i].firstChild.value;
                    paragraph["index"] = listParagraph[i].lastChild.value;
                    $.ajax({
                        url : "/add_paragraph",
                        contentType : "application/json;charset=UTF-8",
                        type : 'post',
                        async:false,
                        data : JSON.stringify(paragraph),
                        success: function (data){

                        },
                        error : function(error) {
                            console.log("ERROR: ", error);
                        }
                    });
                }

                for(let i = 0; i < listImage.length; i++){
                    var image = {};
                    /*var str = listImage[i].firstChild.value;
                    str = str.split("\\");
                    str = str[str.length-1];*/
                    image["content"] = listImage[i].firstChild.value;
                    image["index"] = listImage[i].lastChild.value;
                    $.ajax({
                        url : "/add_image",
                        contentType : "application/json;charset=UTF-8",
                        type : 'post',
                        async:false,
                        data : JSON.stringify(image),
                        success: function (data){

                        },
                        error : function(error) {
                            console.log("ERROR: ", error);
                        }
                    });
                }
            },
            error : function(error) {
                console.log("ERROR: ", error);
            }
        });
    }
}