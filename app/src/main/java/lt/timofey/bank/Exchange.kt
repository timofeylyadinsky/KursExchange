package lt.timofey.bank

import android.os.Parcel
import android.os.Parcelable

data class Exchange(
    val USD_in: String,
    val USD_out: String,
    val EUR_in: String,
    val EUR_out: String,
    val RUB_in: String,
    val RUB_out: String,
    val GBP_in: String,
    val GBP_out: String,
    val CAD_in: String,
    val CAD_out: String,
    val PLN_in: String,
    val PLN_out: String,
    val SEK_in: String,
    val SEK_out: String,
    val CHF_in: String,
    val CHF_out: String,
    val USD_EUR_in: String,
    val USD_EUR_out: String,
    val USD_RUB_in: String,
    val USD_RUB_out: String,
    val RUB_EUR_in: String,
    val RUB_EUR_out: String,
    val JPY_in: String,
    val JPY_out: String,
    val CNY_in: String,
    val CNY_out: String,
    val CZK_in: String,
    val CZK_out: String,
    val NOK_in: String,
    val NOK_out: String,
    val filial_id: String,
    val sap_id: String,
    val info_worktime: String,
    val street_type: String,
    val street: String,
    val filials_text: String,
    val home_number: String,
    val name: String,
    val name_type: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: "",
        parcel.readString()?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(USD_in)
        parcel.writeString(USD_out)
        parcel.writeString(EUR_in)
        parcel.writeString(EUR_out)
        parcel.writeString(RUB_in)
        parcel.writeString(RUB_out)
        parcel.writeString(GBP_in)
        parcel.writeString(GBP_out)
        parcel.writeString(CAD_in)
        parcel.writeString(CAD_out)
        parcel.writeString(PLN_in)
        parcel.writeString(PLN_out)
        parcel.writeString(SEK_in)
        parcel.writeString(SEK_out)
        parcel.writeString(CHF_in)
        parcel.writeString(CHF_out)
        parcel.writeString(USD_EUR_in)
        parcel.writeString(USD_EUR_out)
        parcel.writeString(USD_RUB_in)
        parcel.writeString(USD_RUB_out)
        parcel.writeString(RUB_EUR_in)
        parcel.writeString(RUB_EUR_out)
        parcel.writeString(JPY_in)
        parcel.writeString(JPY_out)
        parcel.writeString(CNY_in)
        parcel.writeString(CNY_out)
        parcel.writeString(CZK_in)
        parcel.writeString(CZK_out)
        parcel.writeString(NOK_in)
        parcel.writeString(NOK_out)
        parcel.writeString(filial_id)
        parcel.writeString(sap_id)
        parcel.writeString(info_worktime)
        parcel.writeString(street_type)
        parcel.writeString(street)
        parcel.writeString(filials_text)
        parcel.writeString(home_number)
        parcel.writeString(name)
        parcel.writeString(name_type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Exchange> {
        override fun createFromParcel(parcel: Parcel): Exchange {
            return Exchange(parcel)
        }

        override fun newArray(size: Int): Array<Exchange?> {
            return arrayOfNulls(size)
        }
    }
}