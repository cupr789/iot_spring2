<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
   <style>
      div.controls {
         margin: 0px 10px;
         font-size: 14px;
         font-family: Tahoma;
         color: #404040;
         height: 80px;
      }
      div#winVP {
         position: relative;
         height: 350px;
         border: 1px solid #dfdfdf;
         margin: 10px;
      }
   </style>
   <script>
   		var winF,popW1,popW2;
   		$(document).ready(function(){
   			winF = new dhtmlXWindows();
   			winF.attachViewportTo("winVP");
   			popW1 = winF.createWindow("win1",20,30,320,300);
   			popW1.setText("회원가입");
   			popW2 = winF.createWindow("win2",20,30,320,300);
   			popW2.setText("삭제");
/*  --1--	var setting ={type:"settings",position:"label-left",labelWidth:100,inputWidth:120}; */
   			var formObj = [{type:"settings",offsetTop:12,name:"connectionInfo",lableAlign:"left" },
   						  {type:"input",name:"uiName",label:"사용자 이름",required:true},
   						  {type:"input",name:"uiId",label:"사용자 ID",required:true},
   						  {type:"password",name:"uiPwd",label:"사용자 PWD",required:true},
   						  {type:"input",name:"uiEmail",label:"Email",required:true},
   						  {type:"block", blockOffset: 0, list:[
   							  {type:"button",name:"saveBtn",value:"가입완료"},
   							  {type:"newcolumn"},
   							  {type:"button",name:"cancelBtn",value:"초기화"}
   						  ]}
   					];
   					
   					

				
   					
   			/* --1-- formObj.push(setting); */
  
   			var form = popW1.attachForm(formObj,true);
   			
   			form.attachEvent("onButtonClick",function(id){
   				if(id=="saveBtn"){
   					if(form.validate()){
   						form.send("${root}/user/insert","POST",callBack);
   					}
   				}else if(id=="cancelBtn"){
   					form.clear();
   				}
   				
   			});
   			
   			var formDelObj = [{type:"settings",offsetTop:12,name:"connectionInfo",lableAlign:"left" },
				  {type:"input",name:"uiNo",label:"삭제할 번호",required:true},
				  {type:"block", blockOffset: 0, list:[
					  {type:"button",name:"delBtn",value:"삭제"},
					  {type:"newcolumn"},
					  {type:"button",name:"cancelBtn",value:"초기화"}
				  ]}
			];
   			
   			
			var formDel = popW2.attachForm(formDelObj,true);
   			
			formDel.attachEvent("onButtonClick",function(id){
   				if(id=="delBtn"){
   					if(formDel.validate()){
   						alert("삭제");
   						formDel.send("${root}/user/delete","get",callBack);
   					}
   				}else if(id=="cancelBtn"){
   					formDel.clear();
   				}
   				
   			});
   			
   		})
   		
   		function callBack(loader,res){
   			var res=JSON.parse(res);
   			alert(res.msg);
   			document.location.href="dx_List";
   		}
   		
   		
   		function setPopW(onOff){
   			
   			if(onOff){
   				popW.show();
   				return;
   			}
   			popW.hide();
   		}
   </script>
<body>
	<div id="winVP"></div>
	<div class="controls">
		<button onclick="setPopW(true)">떠라 창</button>
		<button onclick="setPopW(false)">꺼라 창</button>
	</div>
</body>
</html>