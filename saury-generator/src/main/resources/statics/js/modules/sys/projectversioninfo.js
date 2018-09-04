$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/projectversioninfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'versionId', name: 'versionId', index: 'version_id', width: 50, key: true },
			{ label: '', name: 'projectId', index: 'project_id', width: 80 }, 			
			{ label: '', name: 'versionCode', index: 'version_code', width: 80 }, 			
			{ label: '', name: 'descript', index: 'descript', width: 80 }, 			
			{ label: '', name: 'path', index: 'path', width: 80 }, 			
			{ label: '是否删除  -1：已删除  0：正常', name: 'delFlag', index: 'del_flag', width: 80 }, 			
			{ label: '', name: 'expiredTm', index: 'Expired_tm', width: 80 }, 			
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
		projectVersionInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.projectVersionInfo = {};
		},
		update: function (event) {
			var versionId = getSelectedRow();
			if(versionId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(versionId)
		},
		saveOrUpdate: function (event) {
			var url = vm.projectVersionInfo.versionId == null ? "sys/projectversioninfo/save" : "sys/projectversioninfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.projectVersionInfo),
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
			var versionIds = getSelectedRows();
			if(versionIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/projectversioninfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(versionIds),
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
		getInfo: function(versionId){
			$.get(baseURL + "sys/projectversioninfo/info/"+versionId, function(r){
                vm.projectVersionInfo = r.projectVersionInfo;
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