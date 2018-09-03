$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/travelrouteinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '出发地轨迹id', name: 'parentRouteId', index: 'parent_route_id', width: 80 }, 			
			{ label: '目的地', name: 'name', index: 'name', width: 80 }, 			
			{ label: '纬度', name: 'latitude', index: 'latitude', width: 80 }, 			
			{ label: '经度', name: 'longitude', index: 'longitude', width: 80 }, 			
			{ label: '详细地址', name: 'address', index: 'address', width: 80 }, 			
			{ label: '省', name: 'province', index: 'province', width: 80 }, 			
			{ label: '城市', name: 'city', index: 'city', width: 80 }, 			
			{ label: '区县', name: 'area', index: 'area', width: 80 }, 			
			{ label: '全景图id', name: 'streetId', index: 'street_id', width: 80 }, 			
			{ label: '地图地区uid', name: 'addressUid', index: 'address_uid', width: 80 }, 			
			{ label: '路段距离', name: 'distance', index: 'distance', width: 80 }, 			
			{ label: '路段耗时', name: 'duration', index: 'duration', width: 80 }, 			
			{ label: '创建时间', name: 'createdTm', index: 'created_tm', width: 80 }, 			
			{ label: '更新时间', name: 'updatedTm', index: 'updated_tm', width: 80 }, 			
			{ label: '', name: 'petId', index: 'pet_id', width: 80 }			
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
		travelRouteInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.travelRouteInfo = {};
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
			var url = vm.travelRouteInfo.id == null ? "sys/travelrouteinfo/save" : "sys/travelrouteinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.travelRouteInfo),
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
				    url: baseURL + "sys/travelrouteinfo/delete",
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
			$.get(baseURL + "sys/travelrouteinfo/info/"+id, function(r){
                vm.travelRouteInfo = r.travelRouteInfo;
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