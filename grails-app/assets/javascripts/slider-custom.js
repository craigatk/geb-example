$(function() {
    $( "#rating-slider" ).slider({
        value:1,
        min: 1,
        max: 5,
        step: 1,
        slide: function( event, ui ) {
            $("#rating").val(ui.value);
            $("#rating-amount").text(ui.value);
            console.log('slider moved', ui.value, $("#rating-amount").length);
        }
    });

    $( "#rating-amount" ).text( $( "#rating-slider" ).slider( "value" ) );

});
