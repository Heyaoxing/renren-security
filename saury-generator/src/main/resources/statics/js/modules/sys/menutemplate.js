$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/menutemplate/list',
        datatype: "json",
        colModel: [			
			{ label: 'menuTempId', name: 'menuTempId', index: 'menu_temp_id', width: 50, key: true },
			{ label: '', name: 'projectId', index: 'project_id', width: 80 }, 			
			{ label: '名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '所在菜单id', name: 'menuId', index: 'menu_id', width: 80 }, 			
			{ label: '父级菜单id', name: 'parentId', index: 'parent_id', width: 80 }, 			
			{ label: '类型   0：目录   1：菜单   2：按钮
            ', name: 'type', index: 'type', width: 80 }, 			
			{ label: '菜单图标', name: 'icon', index: 'icon', width: 80 }, 			
			{ label: '排序', name: 'orderNum', index: 'order_num', width: 80 }, 			
			{ label: '创建时间', name: 'createdTm', index: 'created_tm', width: 80 }, 			
			{ label: '创建人', name: 'createdEmp', index: 'created_emp', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		menuTemplate: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.menuTemplate = {};
		},
		update: function (event) {
			var menuTempId = getSelectedRow();
			if(menuTempId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(menuTempId)
		},
		saveOrUpdate: function (event) {
			var url = vm.menuTemplate.menuTempId == null ? "sys/menutemplate/save" : "sys/menutemplate/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.menuTemplate),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var menuTempIds = getSelectedRows();
			if(menuTempIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/menutemplate/delete",
                    contentType: "application/json",
				    data: JSON.stringify(menuTempIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(menuTempId){
			$.get(baseURL + "sys/menutemplate/info/"+menuTempId, function(r){
                vm.menuTemplate = r.menuTemplate;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});