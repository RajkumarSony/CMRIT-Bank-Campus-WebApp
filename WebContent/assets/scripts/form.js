
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

step = 1;
function prev(n) { 
  if(step == 7){
    step = step-2;
  }else{
    --step;
  }
  console.log(step);
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function next(n) { 
	
  //console.log(step1);
  if(step == 6){
    if (n == 1 && !validateForm()) return false;
    console.log("c = "+step);
    //add_beneficiary();
    return false;
  }
  else if(step == 4){
    if (n == 1 && !validateForm()) return false;
    console.log("b = "+step);
    //confirm_beneficiary();
  }
  else if(step < 4 || step == 5){
    // This function will figure out which tab to display
    var x = document.getElementsByClassName("tab");
    // Exit the function if any field in the current tab is invalid:
    if (n == 1 && !validateForm()) return false;
    // Hide the current tab:
    x[currentTab].style.display = "none";
    // Increase or decrease the current tab by 1:
    currentTab = currentTab + n;
    // if you have reached the end of the form...
    if (currentTab >= x.length) {
      // ... the form gets submitted:
      document.getElementById("regForm").submit();
      return false;
    }
    ++step;
    console.log("a = "+step);
    // Otherwise, display the correct tab:
    showTab(currentTab);
  }
}

step1 = 1;
function prev_Acc(n) { 
  if(step1 == 7){
    step1 = step1-2;
  }else{
    --step1;
  }
  console.log(step1);
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function next_Acc(n) { 
	
  //console.log(step1);
  if(step1 == 7){
    if (n == 1 && !validateForm()) return false;
    console.log("c = "+step1);
    //add_account();
    return false;
  }
  else if(step1 == 5){
    if (n == 1 && !validateForm()) return false;
    console.log("b = "+step1);
    //confirm_account();
  }
  else if(step1 == 2){
    if (n == 1 && !validateForm()) return false;
    console.log("c = "+step1);
    
    return;
  }
  else if(step1 < 5 || step1 == 6){
    // This function will figure out which tab to display
    var x = document.getElementsByClassName("tab");
    // Exit the function if any field in the current tab is invalid:
    if (n == 1 && !validateForm()) return false;
    // Hide the current tab:
    x[currentTab].style.display = "none";
    // Increase or decrease the current tab by 1:
    currentTab = currentTab + n;
    // if you have reached the end of the form...
    if (currentTab >= x.length) {
      // ... the form gets submitted:
      document.getElementById("regForm").submit();
      return false;
    }
    ++step1;
    console.log("a = "+step1);
    
    // Otherwise, display the correct tab:
    showTab(currentTab);
  }
}
function open_dashboard(){
  window.location = "dashboard.html";
}

function validateForm() {
  // This function deals with validation of the form fields
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    }
  }
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}


//... toastr nortification code ///

  function nortify(){
      toastr.options.closeButton = true;
      toastr.options.timeOut = 2000;
      toastr.success('Validation code has been sent on your Email-id!','Successfully Sent!');
  }

  status = 1;
  function choose_bank0(){
    
    if(status == 1){
      $("#select_bank").remove();
      status = 0;
    }
  }
  //===========================================}

  //===========================================
  function choose_bank1(){
    
    if(status == 0){

      var code =  '<div id="select_bank">'
                    +'<div class="form-row" style="margin-top: 30px;">'
                        +'<div class="form-group col-md-12">'
                          +'<h4 style="text-align: left; margin-left: -10px;">Select Bank</h4>'
                          +'<hr style="margin-top: -5px; border-width: 1px; margin-left: -15px; margin-right: -15px; margin-bottom: 5px; border-color: #00AAFF;">'
                        +'</div>'
                      +'</div>'
                      +'<p align="left" style="margin-left: 30px;">You can transfer funds to a new beneficiary within SBI and to other banks using account number.?</p><br>'
                      +'<div class="form-row" style="margin-top: 10px;">'
                        +'<div class="form-group col-md-4" style="text-align: left; margin-left: 60px;">'
                          +'<label class="fancy-radio">'
                            +'<input checked name="bank" value="bank1" type="radio">'
                            +'<span><i></i>To Internal</span>'
                          +'</label>'
                        +'</div>'
                        +'<div class="form-group col-md-4" style="text-align: left; margin-left: 60px;">'
                          +'<label class="fancy-radio">'
                            +'<input name="bank" value="bank2" type="radio">'
                            +'<span><i></i>To Other Banks</span>'
                          +'</label>'
                        +'</div>'  
                      +'</div>'                  
                    +'</div>';

      $("#select_bank_main").append(code);
      status = 1;
    }
  }

  function acc_info(){
  swal({
        title: "Are youuuuuu sure?",
        text: "Please, Confirm your given A/c info. is either valid or not!",
        icon: "warning",
        button: {
          confirm: {
            text: "CONFIRM ?",
            value: "okey",
          },
        },
        dangerMode: true,
      })
      .then((value) => {
        if (`${value}` == "okey") {
          swal({
            title: "Awesome!",
            text: "Your given A/c info. is submitted successfully. Thank You!",
            icon: "success",
          });
        } else {
          swal({
            title: "Try Again!",
            text: "Please, Confirm with valid information! Thank You!",
            icon: "info",
            button: "OKEY !",
          });
        }
      });
}