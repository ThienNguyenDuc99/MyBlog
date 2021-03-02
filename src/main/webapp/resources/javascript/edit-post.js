$(document).ready(function () {
    admin2 = new admin2();
});

class admin2 {
    constructor() {
        $(document).on("click", ".sub", this.updatePost);
    }

    updatePost() {
        var listElement = $('.element');
        var listParagraph = $('.element.paragraph');
        var listImage = $('.element.image');
        var paragraph_id = $('.paragraph_id');
        var image_id = $('.image_id');
        var paragraph_content = $('.element_content.paragraph');
        var image_content = $('.element_content.image');
        var paragraph_index = $('.index.paragraph');
        var image_index = $('.index.image');
        var title = listElement[0].value;
        var subject = listElement[1].value;
        var post = {};
        post["id"] = $('.post_id')[0].value;
        post["title"] = title;
        post["subject"] = subject;
        //post["date"] = date;
        //post["author_id"] = 1;
        $.ajax({
            url : "/updatepost",
            contentType : "application/json;charset=UTF-8",
            type : 'put',
            data : JSON.stringify(post),
            success : function(data) {
                for(let i = 0; i < listParagraph.length; i++){
                    var paragraph = {};
                    paragraph["id"] = paragraph_id[i].value;
                    paragraph["content"] = paragraph_content[i].value;
                    paragraph["index"] = paragraph_index[i].value;
                    $.ajax({
                        url : "/update_paragraph",
                        contentType : "application/json;charset=UTF-8",
                        type : 'put',
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
                    image["id"] = image_id[i].value;
                    image["content"] = image_content[i].value;
                    image["index"] = image_index[i].value;
                    $.ajax({
                        url : "/update_image",
                        contentType : "application/json;charset=UTF-8",
                        type : 'put',
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