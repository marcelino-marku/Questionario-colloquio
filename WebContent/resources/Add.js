function add() {

	var new_chq_no = parseInt($('#domanda-hidden').val()) + 1;

	var new_input = "<div><input type='text'  id='new_"+ Number(new_chq_no) + "' name='risposte' placeholder='Inserisci una risposta'></div>";

	$('#contenitore').append(new_input);

	$('#domanda-hidden').val(new_chq_no);

}

function remove() {

	var last_chq_no = $('#domanda-hidden').val();

	if (last_chq_no > 0) {
		$('#new_' + last_chq_no).remove();
		$('#domanda-hidden').val(last_chq_no - 1);

	}

}
