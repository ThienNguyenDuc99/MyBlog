$(document).ready(function () {
    admin = new admin();
});

class admin {
    constructor() {
        $(document).on("click", ".insert_pa", this.addElement);
        $(document).on("click", ".insert_im", this.addElement1);
    }
    addElement(){
        var content = $('.content')
        var append_element = "<div class='element paragraph'></div>"
        content.append(append_element);
        var element_last = $('.element').last();
        var x = "<input class='index' type='number' min='0' max='50' >"
        var x1 = "<textarea class='element_content'>"
        element_last.append(x1);
        element_last.append(x);
    }
    addElement1(){
        var content = $('.content')
        var append_element = "<div class='element image'></div>"
        content.append(append_element);
        var element_last = $('.element').last();
        var x = "<input class='index' type='number' min='0' max='50' >"
        var x1 = '<input type="file" class="custom-file-input" class="element_content">'
        element_last.append(x1);
        element_last.append(x);
    }

}