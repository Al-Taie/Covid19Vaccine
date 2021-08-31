package com.melon.covid_19_vaccine.util

import java.util.ArrayList

object Constant {
    const val DATA_FILE: String = "country_vaccinations.csv"

    object ColumnIndex {
        const val COUNTRY = 0
        const val ISO_CODE = Index.ONE
        const val DATE = Index.TWO
        const val TOTAL_VACCINATIONS = Index.THREE
        const val PEOPLE_VACCINATED = 4
        const val PEOPLE_FULLY_VACCINATED = 5
        const val DAILY_VACCINATIONS_RAW = 6
        const val DAILY_VACCINATIONS = 7
        const val TOTAL_VACCINATIONS_PER_HUNDRED = 8
        const val PEOPLE_VACCINATED_PER_HUNDRED = 9
        const val PEOPLE_FULLY_VACCINATED_PER_HUNDRED = 10
        const val DAILY_VACCINATIONS_PER_MILLION = 11

    }

    object Index {
        const val ONE = 1
        const val TWO = 2
        const val THREE = 3
    }

    object VaccineDetailsIndex {
        const val VACCINE_NAME = 0
        const val DOSE_TAKEN = 1
        const val EFFECTIVENESS = 2
        const val NAME = 3
        const val MANUFACTURER = 4
        const val TYPE_OF_VACCINE = 5
        const val NUMBER_OF_SHOT = 6
        const val HOW_GIVEN = 7
        const val IMAGE_SRC = 8
    }

    object VaccineName {
        const val VACCINE_DETAILS = "Vaccine Details"

        val PFIZER = listOf("Pfizer Vaccine","80%","95%","Name: BNT162b2","Manufacturer: Pfizer, Inc., and BioNTech",
            "Type of Vaccine: mRNA","Number of Shots: 2 shots, 21 days apart","How Given: Shot in the muscle of the upper arm")

        val ASTRAZENECA = listOf("Astrazeneca Vaccine","80%","76%","Name: AZD1222","Manufacturer: AstraZeneca, University of Oxford",
            "Type of Vaccine: Non-reproducible viral vector","Number of Shots: 2 shots, with an interval of 4 to 12 weeks between doses.",
            "How Given: Shot in the muscle of the upper arm.")

        val MODERNA = listOf("Moderna Vaccine","80%","94.1%","Name: mRNA-1273","Manufacturer: ModernaTX, Inc.","Type of Vaccine: mRNA","Number of Shots: 2 shots, 28 days apart",
            "How Given: Shot in the muscle of the upper arm")

        val JOHNSEN_AND_JOHNSEN = listOf("Johnsen & Johnsen Vaccine","80%","66.3%","Name: JNJ-78436735","Manufacturer: Janssen Pharmaceuticals Companies of Johnson & Johnson",
        "Type of Vaccine: Viral Vector","Number of Shots: 1 shot","How Given: Shot in the muscle of the upper arm.")

        val SINOPHARM = listOf("Sinopharm Vaccine","80%","90%","Name: BBIBP-CorV","Manufacturer: Beijing Institute of Biological Products.",
        "Type of Vaccine: Not activated","Number of Shots: two shots, 3 to 4 weeks apart","How Given: Shot in the deltoid muscle")

        const val SINOVAC = "Sinovac Vaccine"
        const val SPUTNIK_V = "Sputnik-V Vaccine"
        const val NOVAVAX = "Novavax Vaccine"
    }

    val COUNTRIES = listOf("Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica",
        "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados",
        "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil",
        "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde",
        "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros",
        "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus",
        "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea",
        "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana",
        "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada",
        "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)",
        "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica",
        "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan",
        "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg",
        "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique",
        "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco",
        "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria",
        "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines",
        "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia",
        "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
        "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka",
        "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
        "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia",
        "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States",
        "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
        "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"
    )
}