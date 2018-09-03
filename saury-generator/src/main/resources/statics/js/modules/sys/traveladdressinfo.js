$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/traveladdressinfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'addressUid', name: 'addressUid', index: 'address_uid', width: 50, key: true },
			{ label: '目的地', name: 'name', index: 'name', width: 80 }, 			
			{ label: '纬度', name: 'latitude', index: 'latitude', width: 80 }, 			
			{ label: '经度', name: 'longitude', index: 'longitude', width: 80 }, 			
			{ label: '详细地址', name: 'address', index: 'address', width: 80 }, 			
			{ label: '省', name: 'province', index: 'province', width: 80 }, 			
			{ label: '城市', name: 'city', index: 'city', width: 80 }, 			
			{ label: '区县', name: 'area', index: 'area', width: 80 }, 			
			{ label: '全景图id', name: 'streetId', index: 'street_id', width: 80 }, 			
			{ label: '创建时间', name: 'createdTm', index: 'created_tm', width: 80 }, 			
			{ label: '更新时间', name: 'updatedTm', index: 'updated_tm', width: 80 }, 			
			{ label: '景点图片链接', name: 'url', index: 'url', width: 80 }			
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
		travelAddressInfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.travelAddressInfo = {};
		},
		update: function (event) {
			var addressUid = getSelectedRow();
			if(addressUid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(addressUid)
		},
		saveOrUpdate: function (event) {
			var url = vm.travelAddressInfo.addressUid == null ? "sys/traveladdressinfo/save" : "sys/traveladdressinfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.travelAddressInfo),
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
			var addressUids = getSelectedRows();
			if(addressUids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/traveladdressinfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(addressUids),
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
		getInfo: function(addressUid){
			$.get(baseURL + "sys/traveladdressinfo/info/"+addressUid, function(r){
                vm.travelAddressInfo = r.travelAddressInfo;
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