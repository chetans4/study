var addBtn = document.getElementById('add');
var removeBtn = document.getElementById('remove');
var searchBtn = document.getElementById('search');
var displayArea = document.getElementById('result');
var msgArea = document.getElementById('messageArea');
var inputData = document.getElementById('input');

var start = null;                                   
var end = null;                                     

display();

function Node ( data ) {                            
  this.data = data;
  this.next = null;
}


function addElement() {
  var data = inputData.value;                             
  if( data == "" ) {
    msgArea.innerHTML="Element cannot be empty";
    return;
  }
  var node = new Node(data);                             
  if (start == null) {                                    
    start = node;
    end = node;
  } else {                                                
    end.next = node;
    end = node;
  }
  display();
  inputData.value="";
  msgArea.innerHTML="Element Added!";
}


function display() {
  var curr = start;
  displayArea.innerHTML="<br>";
  if(start== null){
    msgArea.innerHTML = "No elements to display!!";
  }
  while ( curr != null) {
    displayArea.innerHTML +="<span>"+ curr.data + "-></span>";
    curr = curr.next;
  }
  displayArea.innerHTML += "null";
}


function search() {
  var curr = start;
  var flag = 0;
  var data = inputData.value;
  if( data == "" ) {
    msgArea.innerHTML="Element cannot be empty";
    return;
  }
  displayArea.innerHTML="<br>";
  while( curr!=null ) {
    if( curr.data==data ) {
      flag++;
      displayArea.innerHTML +="<span style='background-color:red;color:white;'>"+ curr.data + "-></span>";
    } else {
      displayArea.innerHTML +="<span>" + curr.data + "-></span>";
    }
    curr = curr.next;
  }
  displayArea.innerHTML += "null";
  if( flag == 0) {
    msgArea.innerHTML = "No Element found!!";
  } else {
    msgArea.innerHTML = "Element found!!";
  }
  inputData.value="";
}


function remove () {
  var data = inputData.value;
  var flag = 0;
  var prev = null;
  var curr = null;
  var curr = start;
  if( (start == null) || (data == "")){
    msgArea.innerHTML = "No element to be removed";
    return;
  } else if ( start.data == data ) {
    start = start.next;
    flag++;
  } else {
    prev = start;
    curr = start.next;
    while ( curr != null ){
      if( curr.data == data ){
        flag++;
        prev.next = curr.next;
        break;
      }
      curr = curr.next;
      prev = prev.next;
    }
  }
  display();
  inputData.value="";
  if(flag==0){
    msgArea.innerHTML = "Element not found";
  } else {
    msgArea.innerHTML = "Element removed";
  }
}
