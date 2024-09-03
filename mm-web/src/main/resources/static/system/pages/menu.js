function openParamMenu(id) {
    layui.use(['table', 'dropdown'], function(){
        const table = layui.table;
        const dropdown = layui.dropdown;
        const layer = layui.layer;

        // 创建渲染实例
        let inst = table.render({
            elem: '#test',
            url:`/page/info/${id}`, // 此处为静态模拟数据，实际使用时需换成真实接口
            parseData: function(res){ // res 即为原始返回的数据
                return {
                    "code": res.code, // 解析接口状态
                    "msg": res.msg, // 解析提示文本
                    "data": res.data.mqParams // 解析数据列表
                };
            },
            response: {
                statusCode: 200 // 规定成功的状态码，默认：0
            },
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            height: '315', // 最大高度减去其他容器已占有的高度差
            css: [ // 重设当前表格样式
                '.layui-table-tool-temp{padding-right: 145px;}'
            ].join(''),
            totalRow: false, // 开启合计行
            page: false,
            cols: [[
                {field:'id', width:80, title: 'ID', sort: true,unresize: true},
                {field: 'message', width: 338, title: '指令', unresize: true, edit: 'textarea'},
                {field:'button',minWidth:100, title:'按钮名称', edit: 'text',unresize: true},
                {field:'sort',minWidth:80, title:'排序', edit: 'text',unresize: true},
                {fixed: 'right', title:'操作', width: 65, toolbar: '#barDemo',unresize: true}
            ]],
            done: function(){
                // 单元格编辑事件
                table.on('edit(test)', function(obj){
                    let update;
                    var field = obj.field; // 得到字段
                    var value = obj.value; // 得到修改后的值
                    var data = obj.data; // 得到所在行所有键值

                    // 值的校验
                    if(value == null || value === ''){
                        layer.msg('值不能为空', {icon: 2});
                        // 还原单元格编辑之前的值
                        update = {};
                        update[field] = obj.oldValue; // 使用旧值
                        obj.update(update);
                        return;
                    }
                    if(field === 'sort'){
                        if(!/^[0-9]*$/.test(value)){
                            layer.msg('排序只能为数字', {icon: 2});
                            // 还原单元格编辑之前的值
                            update = {};
                            update[field] = obj.oldValue; // 使用旧值
                            obj.update(update);
                            return;
                        }
                    }

                    $.ajax({
                        url: '/page/param/update',
                        type: 'post',
                        data: JSON.stringify(data),
                        dataType: 'json',
                        contentType: "application/json",
                        success: function(res){
                            if(res.code !== 200){
                                layer.msg(res.msg, {icon: 2});
                                // 还原单元格编辑之前的值
                                update = {};
                                update[field] = obj.oldValue; // 使用旧值
                                obj.update(update);
                            } else {
                                layer.msg('编辑成功', {icon: 1});
                                // 重新加载表格
                                inst.reloadData();
                            }
                            console.log(data);
                        }
                    });
                });
            },
            error: function(res, msg){
                console.log(res, msg)
            }
        });

        layer.open({
            type: 1, // 页面层
            title: '调试参数编辑',
            area: ['800px', '650px'], // 宽高
            content: $('#modal-message'), // 引用上面的内容
        });

        // 触发单元格工具事件
        table.on('tool(test)', function(obj){ // 双击 toolDouble
            var data = obj.data; // 获得当前行数据
            // console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行 [id: '+ data.id +'] 么', function(index){
                    submitDeleteMessage(data.id);
                });
            }
        });

        // 行单击事件
        table.on('row(test)', function(obj){
            //console.log(obj);
            //layer.closeAll('tips');
        });
        // 行双击事件
        table.on('rowDouble(test)', function(obj){
            console.log(obj);
        });
    });

}
