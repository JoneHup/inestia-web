var html = '<div id="EditorContainer">\n' +
    '                            <div class="toolbar" data-role="editor-toolbar" data-target="#FullEditor">\n' +
    '                                <div class="btn-group">\n' +
    '                                    <div class="btn-group">\n' +
    '                                        <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="字体大小"><i class="fa fa-text-height"></i>&nbsp;<b class="caret"></b></a>\n' +
    '                                        <ul class="dropdown-menu">\n' +
    '                                            <li><a data-edit="fontSize 5" style="font-size: x-large;" >大</a></li>\n' +
    '                                            <li><a data-edit="fontSize 3" style="font-size: medium;">一般</a></li>\n' +
    '                                            <li><a data-edit="fontSize 1" style="font-size: x-small;">小</a></li>\n' +
    '                                        </ul>\n' +
    '                                    </div>\n' +
    '                                    <div class="btn-group">\n' +
    '                                        <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="高亮"><i class="fa fa-paint-brush"></i>&nbsp;<b class="caret"></b></a>\n' +
    '                                        <ul class="dropdown-menu">\n' +
    '                                            <li><a data-edit="backColor #00FFFF">蓝色</a></li>\n' +
    '                                            <li><a data-edit="backColor #00FF00">绿色</a></li>\n' +
    '                                            <li><a data-edit="backColor #FF7F00">橙色</a></li>\n' +
    '                                            <li><a data-edit="backColor #FF0000">红色</a></li>\n' +
    '                                            <li><a data-edit="backColor #FFFF00">黄色</a></li>\n' +
    '                                        </ul>\n' +
    '                                    </div>\n' +
    '                                    <div class="btn-group">\n' +
    '                                        <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="字体颜色"><i class="fa fa-font"></i>&nbsp;<b class="caret"></b></a>\n' +
    '                                        <ul class="dropdown-menu">\n' +
    '                                            <li><a data-edit="foreColor #000000">黑色</a></li>\n' +
    '                                            <li><a data-edit="foreColor #0000FF">蓝色</a></li>\n' +
    '                                            <li><a data-edit="foreColor #30AD23">绿色</a></li>\n' +
    '                                            <li><a data-edit="foreColor #FF7F00">橙色</a></li>\n' +
    '                                            <li><a data-edit="foreColor #FF0000">红色</a></li>\n' +
    '                                            <li><a data-edit="foreColor #FFFF00">黄色</a></li>\n' +
    '                                        </ul>\n' +
    '                                    </div>\n' +
    '                                </div>\n' +
    '                                <div class="btn-group">\n' +
    '                                    <a class="btn btn-default" data-edit="bold" title="加粗 (Ctrl/Cmd+B)"><i class="fa fa-bold"></i></a>\n' +
    '                                    <a class="btn btn-default" data-edit="italic" title="斜体 (Ctrl/Cmd+I)"><i class="fa fa-italic"></i></a>\n' +
    '                                    <a class="btn btn-default" data-edit="strikethrough" title="删除线"><i class="fa fa-strikethrough"></i></a>\n' +
    '                                    <a class="btn btn-default" data-edit="underline" title="下划线 (Ctrl/Cmd+U)"><i class="fa fa-underline"></i></a>\n' +
    '                                </div>\n' +
    '                                <div class="btn-group">\n' +
    '                                    <a class="btn btn-default" data-edit="insertunorderedlist" title="列表"><i class="fa fa-list-ul"></i></a>\n' +
    '                                    <a class="btn btn-default" data-edit="insertorderedlist" title="序列"><i class="fa fa-list-ol"></i></a>\n' +
    '                                    <a class="btn btn-default hidden-xs" data-edit="indent" title="重点 (Tab)"><i class="fa fa-indent"></i></a>\n' +
    '                                </div>\n' +
    '                                <div class="btn-group">\n' +
    '                                    <a class="btn btn-default" data-edit="justifyleft" title="居左 (Ctrl/Cmd+L)"><i class="fa fa-align-left"></i></a>\n' +
    '                                    <a class="btn btn-default" data-edit="justifycenter" title="居中 (Ctrl/Cmd+E)"><i class="fa fa-align-center"></i></a>\n' +
    '                                    <a class="btn btn-default" data-edit="justifyright" title="居右 (Ctrl/Cmd+R)"><i class="fa fa-align-right"></i></a>\n' +
    '                                    <a class="btn btn-default" data-edit="justifyfull" title="适应 (Ctrl/Cmd+J)"><i class="fa fa-align-justify"></i></a>\n' +
    '                                </div>\n' +
    '                                <div class="btn-group">\n' +
    '                                    <a class="btn btn-default hidden-xs" data-edit="format-pre" title="代码"><i class="fa fa-code"></i></a>\n' +
    '                                    <div class="btn-group">\n' +
    '                                        <a class="btn btn-default dropdown-toggle" data-toggle="dropdown" title="标题"><i class="fa fa-header"></i>&nbsp;<b class="caret"></b></a>\n' +
    '                                        <ul class="dropdown-menu">\n' +
    '                                            <li><a data-edit="format-h1">一级标题</a></li>\n' +
    '                                            <li><a data-edit="format-h2">二级标题</a></li>\n' +
    '                                            <li><a data-edit="format-h3">三级标题</a></li>\n' +
    '                                            <li><a data-edit="format-h4">四级标题</a></li>\n' +
    '                                            <li><a data-edit="format-h5">五级标题</a></li>\n' +
    '                                        </ul>\n' +
    '                                    </div>\n' +
    '                                    <a class="btn btn-default hidden-xs" title="插入图片(可以拖拽)" id="pictureBtn">\n' +
    '                                        <i class="fa fa-picture-o"></i>\n' +
    '                                        <input class="imgUpload" type="file" style="opacity: 0; position: absolute; top: 0px; left: 0px; width: 41px; height: 30px;" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />\n' +
    '                                    </a>\n' +
    '                                </div>\n' +
    '                            </div>\n' +
    '                            <div class="editor" id="FullEditor" name="content" data-placeholder="文章正文等待输入..."></div>\n' +
    '                        </div>';

$(function () {
    // bootstrap table初始化
    // http://bootstrap-table.wenzhixin.net.cn/zh-cn/documentation/
    var $table = $('#table');
    $table.bootstrapTable({
        url: CONTEXT_PATH + '/news/list',
        idField: 'id',
        columns: [
            {field: 'state', checkbox: true},
            {field: 'id', title: '编号', sortable: true, halign: 'left', visible: false},
            {field: 'title', title: '标题', sortable: true, halign: 'left'},
            {field: 'source', title: '来源', sortable: true, halign: 'left'},
            {field: 'content', title: '内容', sortable: true, halign: 'left',formatter:function(value,row,index){
                    if(value){
                        var length=value.length;
                        if(length&&length>10){
                            return"<span title ='"+value+"'>"+value.substring(0,10)+ "..." +"</span>"
                        }
                        return"<span title ='"+value+"'>"+value+"</span>"
                    }
                }
            },
            {field: 'creatorName', title: '创建人', sortable: true, halign: 'left'},
            {field: 'modifyTime', title: '创建时间', sortable: true, halign: 'left'},
            {
                field: 'action',
                title: '操作',
                halign: 'center',
                align: 'center',
                formatter: 'actionFormatter',
                events: 'actionEvents',
                clickToSelect: false
            }
        ]
    });

    $("#addBtn").click(function () {

        if($("#content").next()){
            $("#content").next().remove();
        }
        $("#content").after(html);

        var editorFrushHandler = null;
        $('#FullEditor').wysiwyg();
        $('#FullEditor').on('change',function () {
            $('#Show').html($('#FullEditor').html());
            if(editorFrushHandler!=null) clearTimeout(editorFrushHandler);
            editorFrushHandler = setTimeout(function () {
                $('#FullEditor pre').removeClass('prettyprinted').addClass('prettyprint');
                PR.prettyPrint();
                editorFrushHandler = null;
            },3000);
            $("#content").val($('#FullEditor').html());
        });
``
        $('#EditorContainer').css('width','100%').css('height',$(window).height()+'px');
        $('#EditorContainer .editor').css('height',($('#EditorContainer').height()-$('#EditorContainer .toolbar').height()-20-10-57)+'px');
    });

    $("#editBtn").click(function () {

        alert(222)

    });



});

function editAfter(obj, row) {
    if($("#editContent").next()){
        $("#editContent").next().remove();
    }
    $("#editContent").after(html);

    var editorFrushHandler = null;
    $('#FullEditor').wysiwyg();
    $('#FullEditor').on('change',function () {
        $('#Show').html($('#FullEditor').html());
        if(editorFrushHandler!=null) clearTimeout(editorFrushHandler);
        editorFrushHandler = setTimeout(function () {
            $('#FullEditor pre').removeClass('prettyprinted').addClass('prettyprint');
            PR.prettyPrint();
            editorFrushHandler = null;
        },3000);
        $("#content").val($('#FullEditor').html());
        $("#editContent").val($('#FullEditor').html());
    });

    $('#EditorContainer').css('width','100%').css('height',$(window).height()+'px');
    $('#EditorContainer .editor').css('height',($('#EditorContainer').height()-$('#EditorContainer .toolbar').height()-20-10-57)+'px');

    console.log("editContent====" + $("#editContent").val());
    $("#FullEditor").append($("#editContent").val());
}

function actionFormatter(value, row, index) {
    return $('#actionButtons').html();
}

window.actionEvents = {
    'click .like': function (e, value, row, index) {
        alert('You click like icon, row: ' + JSON.stringify(row));
        console.log(value, row, index);
    },
    'click .edit': function (e, value, row, index) {
        $('#editModal').modal('show');
        console.log(row)
        $('#editForm').fillForm(row);
        editAfter('', row);
        // console.log(value, row, index);
    },
    'click .remove': function (e, value, row, index) {
        $('#deleteModal').modal('show');
        $('.records').html('1');
        var html = '';
        for (var key in row) {
            html += '<input type="hidden" name="' + key + '" value="' + row[key] + '">';
        }
        $('#deleteForm').html(html);
    }
};

function onClick(e, treeId, treeNode) {
}

function hideMenu() {
    $("#menuContent").fadeOut("fast");
    // $("body").unbind("mousedown", onBodyDown);
}

function onBodyDown(event) {
    if (!(event.target.id == "organizationName" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length > 0)) {
        hideMenu();
    }
}