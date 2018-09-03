$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/chinaareainfo/list',
        datatype: "json",
        colModel: [			
			{ label: 'areaid', name: 'areaid', index: 'AreaID', width: 50, key: true },
			{ label: '名称', name: 'name', index: 'Name', width: 80 }, 			
			{ label: '父级id', name: 'parentid', index: 'ParentId', width: 80 }, 			
			{ label: '简称', name: 'shortname', index: 'ShortName', width: 80 }, 			
			{ label: '层级', name: 'leveltype', index: 'LevelType', width: 80 }, 			
			{ label: '城市代码', name: 'citycode', index: 'CityCode', width: 80 }, 			
			{ label: '邮编', name: 'zipcode', index: 'ZipCode', width: 80 }, 			
			{ label: '完整地区名称', name: 'mergername', index: 'MergerName', width: 80 }, 			
			{ label: '经度', name: 'lng', index: 'lng', width: 80 }, 			
			{ label: '纬度', name: 'lat', index: 'Lat', width: 80 }, 			
			{ label: '拼音', name: 'pinyin', index: 'Pinyin', width: 80 }			
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
		chinaareainfo: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.chinaareainfo = {};
		},
		update: function (event) {
			var areaid = getSelectedRow();
			if(areaid == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(areaid)
		},
		saveOrUpdate: function (event) {
			var url = vm.chinaareainfo.areaid == null ? "sys/chinaareainfo/save" : "sys/chinaareainfo/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.chinaareainfo),
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
			var areaids = getSelectedRows();
			if(areaids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/chinaareainfo/delete",
                    contentType: "application/json",
				    data: JSON.stringify(areaids),
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
		getInfo: function(areaid){
			$.get(baseURL + "sys/chinaareainfo/info/"+areaid, function(r){
                vm.chinaareainfo = r.chinaareainfo;
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