$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/projectinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'projectId', name: 'projectId', index: 'project_id', width: 50, key: true },
			{ label: '项目名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '项目描述', name: 'descript', index: 'descript', width: 80 }, 			
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
		projectInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.projectInfo = {};
		},
		update: function (event) {
			var projectId = getSelectedRow();
			if(projectId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(projectId)
		},
		saveOrUpdate: function (event) {
			var url = vm.projectInfo.projectId == null ? "sys/projectinfo/save" : "sys/projectinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.projectInfo),
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
			var projectIds = getSelectedRows();
			if(projectIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/projectinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(projectIds),
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
		getInfo: function(projectId){
			$.get(baseURL + "sys/projectinfo/info/"+projectId, function(r){
                vm.projectInfo = r.projectInfo;
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