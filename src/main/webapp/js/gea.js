
 
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
    x.appendChild( new_row );
}
