
<html>

<head>

   <link href="css/common.css" rel="stylesheet">

<script> 

  function displayTime()
	  {
		sessionStorage.setItem("duration",sessionStorage.getItem("duration")-1);
		var  remainingSeconds=sessionStorage.getItem("duration");//125
		var  minutes = Math.floor(remainingSeconds/60);//125/60=2
		var  seconds = remainingSeconds%60;//125/60=5

document.getElementById("remainingtime").innerHTML=" remaining time " + minutes + ":" + seconds;

		if(remainingSeconds==0)
				{
				  location.href="/endexam";
			    }
		 }
               /* 1000 ms - 1 sec . It means displayTime() will be called after every 1 second  */
	     setInterval(displayTime,1000);	

	function changeColor()
			 {
				var allAnswers=document.getElementsByTagName("span");
			    var allRadioButtons=document.getElementsByName("submittedAnswer");	
			    var previousAnswer=document.getElementById("previousAnswer").value;
						
					for(var i=0;i<4;i++)
						{
						  console.log (allAnswers[i].innerText.length)
				          console.log (previousAnswer.length)
								
						if(allAnswers[i].innerText.trim()==previousAnswer.trim())
								   {
							          allAnswers[i].style.color="orange";
									  allRadioButtons[i].checked=true;
									  break;
								   }
						}
			  }
		
		</script>
</head>

<body onload="changeColor()">

<img src="${imagepath}" width=120 height=110>

<p style="color:red;position:absolute;top:0px;right:50px;color:red;font-size:40px" id="remainingtime"></p>

<h1 style="text-align:center;color:black;margin-bottom:150px;"> Questions </h1>

<h2 style="color:green;">${message}</h2>


<form>

<div id="maincontent">

<input type="text" style="border:red; background-color:black; color:white"  name="qno"   value="${question.qno}"   style="border:red"><br>
<input type="text" style="border:red; background-color:black; color:white"  name="qtext" value="${question.qtext}" size="50px"  style="border:red"><br><br>

<br><br>

// 4 radio button & 4 span
<input type="radio"  name="submittedAnswer"   value="${question.op1}">  <span>${question.op1}</span>
<input type="radio"  name="submittedAnswer"   value="${question.op2}">  <span>${question.op2}</span> 
<input type="radio"  name="submittedAnswer"   value="${question.op3}">  <span>${question.op3}</span> 
<input type="radio"  name="submittedAnswer"   value="${question.op4}">  <span>${question.op4}</span>

<input style="display:none" type="text" name="originalAnswer" value="${question.answer}"><br><br>

<input style="display:none" id="previousAnswer" value="${previousAnswer}"><br><br>


<input type="submit" style="border:red; background-color:black; color:white" value="next"      formaction="next"     class="btn">
<input type="submit" style="border:red; background-color:black; color:white" value="previous"  formaction="previous" class="btn">
<input type="submit" style="border:red; background-color:black; color:white" value="endexam"   formaction="endexam"  class="btn">

</div>

</form>

</body>

</html>