<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<style>
   div#winVP {
      position: relative;
      height: 100%;
      border: 1px solid #dfdfdf;
      margin: 10px;
   }
</style>
<script>
   var winF,popW;
   $(document).ready(function(){
      winF = new dhtmlXWindows();
      winF.attachViewportTo("winVP");
      popW = winF.createWindow("win1",20,30,450,500);
      //popW.hide(); 
      popW.button("close").hide();
      popW.button("minmax").hide();
      popW.button("park").hide();
      popW.setText("Login"); 

      winF.window("win1").centerOnScreen();
      winF.window("win1").denyMove();
      winF.window("win1").denyResize();
      var formObj = [
                 {type:"settings", offsetTop:12,name:"connectionInfo",labelAlign:"left"},
               {type:"input",name:"uiName", label:"사용자명 : ",required:true},
               {type:"input",name:"uiId", label:"사용자 Id : ",required:true},
               {type:"password",name:"uiPwd", label:"사용자 Pwd : ",required:true},
               {type:"input",name:"uiEmail", label:"Email : ",required:true},
               {type:"radio",name:"admin", label:"관리자 권한 : ",checked:"0", list:[
            	   {type: "radio",name: "admin", value:"0", label:"예", checked: true},
            	   {type: "radio",name: "admin", value:"1", label:"아니오"}
            	   ]},
               {type: "block", blockOffset: 0, list: [
                  {type: "button", name:"joinBtn",value: "회원가입"},
                  {type: "newcolumn"},
                  {type: "button", name:"cancelBtn",value: "취소"},
                  {type: "newcolumn"},
                  {type: "button", name:"backBtn",value: "돌아가기"}
               ]}
         ];
      var form = popW.attachForm(formObj,true);
      
      form.attachEvent("onButtonClick",function(id){
         if(id=="joinBtn"){
            if(form.validate()){
            	var aud = new AjaxUtilDx("${root}/user/join",form);
            	aud.send(callback);
            }
         }else if(id=="cancelBtn"){
            form.clear();
         }else if(id=="backBtn"){
        	 location.href="${pPath}/user/login";
         }
      });

   });
   
   function callback(loader, res){
	  console.log(res);
   }

</script>
<body>
   <div id="winVP"></div>
</body>
</html>