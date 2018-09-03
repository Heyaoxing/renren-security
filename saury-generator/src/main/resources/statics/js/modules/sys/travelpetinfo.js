$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/travelpetinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '', name: 'userId', index: 'user_id', width: 80 }, 			
			{ label: '父代id', name: 'parentPetId', index: 'parent_pet_id', width: 80 }, 			
			{ label: '第几代', name: 'generation', index: 'generation', width: 80 }, 			
			{ label: '昵称', name: 'nickname', index: 'nickname', width: 80 }, 			
			{ label: '类型
            1：猫
            2：老鼠', name: 'petType', index: 'pet_type', width: 80 }, 			
			{ label: '得到下雨数', name: 'receiveRainNum', index: 'receive_rain_num', width: 80 }, 			
			{ label: '累计抓捕老鼠数', name: 'mousetrapTotal', index: 'mousetrap_total', width: 80 }, 			
			{ label: '抓捕老鼠数', name: 'mousetrapNum', index: 'mousetrap_num', width: 80 }, 			
			{ label: '状态
            100：路途中
            200：到达地点
            300：异常', name: 'status', index: 'status', width: 80 }, 			
			{ label: '状态描述', name: 'statusDesc', index: 'status_desc', width: 80 }, 			
			{ label: '是否被捕
            0:否
            1:是', name: 'isArrested', index: 'is_arrested', width: 80 }, 			
			{ label: '创建时间', name: 'createdTm', index: 'created_tm', width: 80 }, 			
			{ label: '更新时间', name: 'updatedTm', index: 'updated_tm', width: 80 }, 			
			{ label: '当前所在地uid', name: 'addressUid', index: 'address_uid', width: 80 }			
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
		travelPetInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.travelPetInfo = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.travelPetInfo.id == null ? "sys/travelpetinfo/save" : "sys/travelpetinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.travelPetInfo),
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
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/travelpetinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
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
		getInfo: function(id){
			$.get(baseURL + "sys/travelpetinfo/info/"+id, function(r){
                vm.travelPetInfo = r.travelPetInfo;
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