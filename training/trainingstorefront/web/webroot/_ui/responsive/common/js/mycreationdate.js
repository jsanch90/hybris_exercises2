ACC.myCreationDate = {

    _autoload: [
        "submitCreationDate"
    ],

    submitCreationDate: function () {
        let currentDate = new Date();
        let minDate = currentDate.toISOString().substring(0,10);
        $('#myCreationDateFormInput').prop('max', minDate);
        $('.my_creation_date_form_submit').click(function () {
            if ($("#myCreationDateFormInput").val() == "" ) {
                alert("Invalid date");
            } else {
                console.log($("#myCreationDateFormInput").val());
                console.log($("#productCode").val());
                $('#my-creation-date-form').ajaxSubmit({
                    success: function () {
                        alert("MyCreationDate attribute updated!");
                        let newDate = new Date($("#myCreationDateFormInput").val());
                        newDate.setHours(newDate.getHours()+24);
                        //Time between current date and new creation date
                        let timeDifference = currentDate - newDate.getTime();
                        let newPastDays = Math.ceil(timeDifference / (1000 * 3600 * 24));
                        $(".past-days").text(newPastDays.toString());
                        $(".creation-date").text(newDate.toDateString());
                    }
                })

            }
        })
    }
}