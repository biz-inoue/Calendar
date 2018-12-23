$(document).ready(function() {
    $('#calendar').fullCalendar({
        timeFormat: 'HH:mm',
        timezone: 'Asia/Tokyo',
        navLinks: true,
        eventLimit: true,
        editable: false,
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
        events: function(start, end, timezone, callback) {
            setCalendarList(start.format('YYYY-MM-DD'), end.format('YYYY-MM-DD'), callback);
        }
    });
});
function setCalendarList(startDate, endDate, callback) {
	  $.ajax({
	    type: 'get',
	    dataType : "text",
	    async: true,
	    cache: false,
	    url : '/api/event/all'
	  })
	  .then(
	    function(data) {
	      var obj = jQuery.parseJSON(data);
	      var events = [];
	      $.each(obj, function(index, value) {
	        events.push({
	          id: value['id'],
	          title: value['title'],
	          start: value['start'],
	          end: value['end']
	        });
	      });
	      callback(events);
	    }
	  );
	  return;
}