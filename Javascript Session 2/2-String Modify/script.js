var inputStr = document.getElementById('input');
var display = document.getElementById('result');


function removeDuplicates( input ) {
  for( var i=0,c; i<input.length-1;i++){
     c = i + 1;
     while(input[i]==input[c]){             
       if(c<input.length){
         c++;
       } else {
         break;
       }
     }
     if(c != (i+1) ){                       
     var part1 = input.substring(0,i);
     var part2 = input.substring(c);
     var newInput = part1+part2;
     return removeDuplicates(newInput);
   }
  }
  return input;                            
}

function disp (){
  var input = inputStr.value;            
  display.innerHTML = "Output string is = "+ removeDuplicates(input);
}
