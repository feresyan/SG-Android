package id.my.fazan.learnsgmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public String nama, gender;
    public int id,umur;

    //Nama Tabel
    public static final String TABLE = "user";
    //Atribut tabel
    public static final String KEY_ID = "id";
    public static final String KEY_nama = "nama";
    public static final String KEY_umur = "umur";
    public static final String KEY_gender = "gender";

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(this.nama);
        dest.writeString(this.gender);
        dest.writeInt(this.umur);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.id = in.readInt();
        this.nama = in.readString();
        this.gender = in.readString();
        this.umur = in.readInt();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
