<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- <link rel="stylesheet" href="https://omni.bizmeka.com/widget/css/widget.css"> -->
    <link rel="stylesheet" href="https://dev.communicationcloud.co.kr/widget/css/widget.css">
    <!-- <link rel="stylesheet" href="http://localhost:8002/css/widget.css"> -->
    <!-- <title>Agent Widget Template</title> -->
    <style>
        button,
        input {
            margin-top: 5px;
            font-size: 11px;
        }

        #txt_logBox {
            margin-top: 10px;
            width: 100%;
            font-size: 11px;
        }

        textarea {
            height: 100px;
        }

        iframe {
            height: 100%;
            width: 100%;
        }
    </style>
</head>
<body>
    <div>
        <textarea rows="20" cols="50" id="txt_logBox" style="display:none;"></textarea><br>
    </div>
    <!-- <iframe src="https://lifenet.healthcare.siemens.com/welcome" width="100%" height="100%" frameborder="0" style="overflow:hidden;overflow-x:hidden;overflow-y:hidden;height:100%;width:100%;left:0px;right:0px;bottom:0px"></iframe> -->

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://dev.communicationcloud.co.kr/widget/js/widget.js"></script>
    <script>
        $(document).ready(function () {
            widget.init(false, 'ujung@gmail.com', 'cloud!@#$', 'https://dev.communicationcloud.co.kr', 'fix');
            widget.clientEventFncName = mainEvent; //Even Function
        });
        
        var mainEvent = function (eventName, eventData, responseCode, responseText) {
            console.log("----------------Event------------------");
            console.log("[" + getTimeStamp() + "]" + "[-------" + eventName + "-------]" + "[" + responseCode + "]:" );
            if (eventData != null) {
                if (eventData.participants) {
                    //logView("[Number of participants]:" + eventData.participants.length);
                }
                //logView(JSON.stringify(eventData));
            }
            switch (eventName) {
                case "Established":
                	logView("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    axios.get('/xcalls/07042609618')
                    .then(function(response){
                      console.log(response);
                      vm.info = response.data;
                      console.log(vm.info.custName);
                    }).catch(function(e){
                      console.error(e);
                    })                 	
                    break;
                default:

            }

        };

        var logView = function (text) {
            // text = text + "\n ";
            console.log(text);
            $('#txt_logBox').append(text);
            $('#txt_logBox').append('\n');
            $('#txt_logBox').scrollTop(999999);
        }
        
        function getTimeStamp() {
            var d = new Date();

            var s =
                leadingZeros(d.getFullYear(), 4) + '-' +
                leadingZeros(d.getMonth() + 1, 2) + '-' +
                leadingZeros(d.getDate(), 2) + ' ' +

                leadingZeros(d.getHours(), 2) + ':' +
                leadingZeros(d.getMinutes(), 2) + ':' +
                leadingZeros(d.getSeconds(), 2);

            return s;
        }

        function leadingZeros(n, digits) {
            var zero = '';
            n = n.toString();

            if (n.length < digits) {
                for (i = 0; i < digits - n.length; i++)
                    zero += '0';
            }
            return zero + n;
        }
    </script>
    
 <div id="app">
	<table>
	<tr>
		<td>
			<fieldset>
			<legend>고객 및 차량정보</legend>
			<ul>
				<li>
					<label for="call_id">인입번호</label>
					<input type="text" id="call_id">
				</li>
				<li>
					<label for="cust_name">고객명</label>
					<span v-if="info">{{info.custName}}</span>
				</li>
			</ul>
			</fieldset>
		</td>
		<td>
			<form action="">
			<fieldset>
			<legend>상담정보</legend>
			<ul>
				<li>
					<label for="counsel_type">상담유형</label>
					<input type="text" id="counsel_type">
				</li>
				<li>
					<label for="counsel_contents">상담내용</label>
					<textarea rows="10" cols="50" id="counsel_contents"></textarea>
				</li>
				<li>
					<label for="counsel_memo">비고</label>
					<textarea rows="5" cols="50" id="counsel_memo"></textarea>
				</li>
			</ul>
			</fieldset>
			<input type="submit">
			</form>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<fieldset>
		<legend>상담이력</legend>
			<table>
			<thead>
				<tr>
					<th>접수번호</th>
					<th>분류</th>
					<th>콜타입</th>
					<th>고객명</th>
					<th>인입번호</th>
					<th>상담일시</th>
					<th>상담원</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1111</td>
					<td>in</td>
					<td>eCall</td>
					<td>홍길동</td>
					<td>010-8509-5072</td>
					<td>2019-04-17 12:05:00</td>
					<td>김미소(1234)</td>
				</tr>
				<tr>
					<td>1111</td>
					<td>in</td>
					<td>eCall</td>
					<td>홍길동</td>
					<td>010-8509-5072</td>
					<td>2019-04-17 12:05:00</td>
					<td>김미소(1234)</td>
				</tr>
				<tr>
					<td>1111</td>
					<td>in</td>
					<td>eCall</td>
					<td>홍길동</td>
					<td>010-8509-5072</td>
					<td>2019-04-17 12:05:00</td>
					<td>김미소(1234)</td>
				</tr>
			</tbody>
			</table>
		</fieldset>
		</td>
	</tr>
	</table>
	</div>
	
    <script src="https://unpkg.com/vue@2.6.10/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script>
    
    var vm = new Vue({
      el: '#app',
      data: {
    	  info : null
      },
      mounted() {
    	  /**
          axios.get('/xcalls/07042609618')
          .then(function(response){
            console.log(response);
            vm.info = response.data;
            console.log(vm.info.custName);
          }).catch(function(e){
            console.error(e);
          }) 
    	  **/
      }
    })
    </script>    
</body>

</html>