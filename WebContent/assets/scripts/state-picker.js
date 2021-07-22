$(function () {
    var states = [
        {
            "name": "-------- Select --------"
    },
        {
            "name": "Andhra Pradesh",
            "code": "AP"
    },
    	{
            "name": "Andaman and Nicobar Islands",
            "code": "AN"
    },
    	{
            "name": "Arunachal Pradesh",
            "code": "AR"
    },
    	{
            "name": "Assam",
            "code": "AS"
    },
    	{
            "name": "Bihar",
            "code": "BR"
    },
    	{
            "name": "Chandigarh",
            "code": "CH"
    },
    	{
            "name": "Chhattisgarh",
            "code": "CT"
    },
    	{
            "name": "Dadar and Nagar Haveli",
            "code": "DN"
    },
    	{
            "name": "Daman and Diu",
            "code": "DD"
    },
    	{
            "name": "Delhi",
            "code": "DL"
    },
    	{
            "name": "Goa",
            "code": "GA"
    },
    	{
            "name": "Gujarat",
            "code": "GJ"
    },
    	{
            "name": "Haryana",
            "code": "HR"
    },
    	{
            "name": "Himachal Pradesh",
            "code": "HP"
    },
    	{
            "name": "Jammu and Kashmir",
            "code": "JK"
    },
    	{
            "name": "Jharkhand",
            "code": "JH"
    },
    	{
            "name": "Karnataka",
            "code": "KA"
    },
    	{
            "name": "Kerala",
            "code": "KL"
    },
    	{
            "name": "Lakshadweep",
            "code": "LD"
    },
    	{
            "name": "Madhya Pradesh",
            "code": "MP"
    },
    	{
            "name": "Maharashtra",
            "code": "MH"
    },
    	{
            "name": "Manipur",
            "code": "MN"
    },
    	{
            "name": "Meghalaya",
            "code": "ML"
    },
    	{
            "name": "Mizoram",
            "code": "MZ"
    },
    	{
            "name": "Nagaland",
            "code": "NL"
    },
    	{
            "name": "Odisha",
            "code": "OR"
    },
    	{
            "name": "Puducherry",
            "code": "PY"
    },
    	{
            "name": "Punjab",
            "code": "PB"
    },
    	{
            "name": "Rajasthan",
            "code": "RJ"
    },
    	{
            "name": "Punjab",
            "code": "PB"
    },
    	{
            "name": "Sikkim",
            "code": "SK"
    },
    	{
            "name": "Tamil Nadu",
            "code": "TN"
    },
    	{
            "name": "Telangana",
            "code": "TG"
    },
    	{
            "name": "Tripura",
            "code": "TR"
    },
    	{
            "name": "Uttar Pradesh",
            "code": "UP"
    },
    	{
            "name": "Uttarakhand",
            "code": "UT"
    },
    	{
            "name": "West Bengal",
            "code": "WB"
    }
]

	var stateInput = $(document).find('.statepicker');
    var stateList = "";

    //set defaults
    for (i = 0; i < stateInput.length; i++) {
       
        stateList ="";
            
        $.each(states, function (index, state) {
            stateList += "<option data-state-code='" + state.code + "' data-tokens='" + state.code + " " + state.name + "' value='" + state.name + "'>" + state.name + "</option>";
        });
                
        //append country list
        stateInput.eq(i).html(stateList);

        //check if default
        def = stateInput.eq(i).data('default');
        //if there's a default, set it

        if (def) {
            stateInput.eq(i).val(def);
        }
    }
});
