$(function () {
    $("#jqGrid").jqGrid({
        url: 'sys/generator/list',
        datatype: "json",
        colModel: [			
			{ label: '表名', name: 'tableName', width: 100,align :'center', key: true },
			{ label: 'Engine', name: 'engine',align :'center', width: 50},
			{ label: '表备注', name: 'tableComment',align :'center', width: 100 },
            { label: '创建时间', name: 'createTime',align :'center', width: 100 },
            { label: '上级菜单', name: 'parentMenu',formatter:function (cellvalue, options, rowObject) {return getOptionValue();}}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50,100,200],
        rownumbers: true, 
        rownumWidth: 25,
        shrinkToFit:true,
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

    function getOptionValue(){
        return "<select><option value='0'>系统菜单</option><option value='1'>用户设置</option></select>";
    }
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			tableName: null
		}
	},
	methods: {
		query: function () {
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'tableName': vm.q.tableName},
                page:1 
            }).trigger("reloadGrid");
		},
		generator: function() {
			var tableNames = getSelectedRows();
			if(tableNames == null){
				return ;
			}
            location.href = "sys/generator/code?tables=" + tableNames.join();
		}
	}
});

