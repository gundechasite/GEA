
 
function deleteRow(row)
{
	var x=document.getElementById('POITable');
	
	if (x.rows.length == 2) {
		return false; //if only 2 rows is there(heading+1 data row) , it cannot be deleted
	}
    var i=row.parentNode.parentNode.rowIndex;
    document.getElementById('POITable').deleteRow(i);
}


function insRow()
{
    var x=document.getElementById('POITable');
    var new_row = x.rows[1].cloneNode(true);
    var cleared_new_row = cleanUpInputs(new_row);
    x.appendChild( new_row );
}

function cleanUpInputs(obj) {
    var focusNode = null;
 
    for (var i = 0; n = obj.childNodes[i]; ++i) {
        if (n.childNodes && n.tagName != 'INPUT') {
            cleanUpInputs(n);
        } else if (n.tagName == 'INPUT' && n.type == 'text') {
            focusNode = n;
            n.value = '';
        }
    }
 
    return focusNode;
}