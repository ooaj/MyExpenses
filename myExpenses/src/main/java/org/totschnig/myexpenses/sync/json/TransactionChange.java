package org.totschnig.myexpenses.sync.json;


import android.database.Cursor;
import android.support.annotation.Nullable;

import com.gabrielittner.auto.value.cursor.ColumnName;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import org.totschnig.myexpenses.util.TextUtils;

import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_AMOUNT;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_CATID;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_COMMENT;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_CR_STATUS;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_DATE;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_METHODID;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_PARENT_UUID;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_PAYEEID;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_PICTURE_URI;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_REFERENCE_NUMBER;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_TRANSFER_ACCOUNT;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_TYPE;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_UUID;

@AutoValue
public abstract class TransactionChange {

  public static TransactionChange create(Cursor cursor) {
    return AutoValue_TransactionChange.createFromCursor(cursor);
  }

  public static TypeAdapter<TransactionChange> typeAdapter(Gson gson) {
    return new AutoValue_TransactionChange.GsonTypeAdapter(gson);
  }

  public static Builder builder() {
    return new AutoValue_TransactionChange.Builder();
  }

  @ColumnName(KEY_TYPE)
  public abstract String type();

  @ColumnName(KEY_UUID)
  @Nullable
  public abstract String uuid();

  @ColumnName(KEY_PARENT_UUID)
  @Nullable
  abstract String parentUuid();

  @ColumnName(KEY_COMMENT)
  @Nullable
  abstract String comment();

  @ColumnName(KEY_DATE)
  @Nullable
  abstract Long date();

  @ColumnName(KEY_AMOUNT)
  @Nullable
  abstract Long amount();

  @ColumnName(KEY_CATID)
  @Nullable
  abstract Long catId();

  @ColumnName(KEY_PAYEEID)
  @Nullable
  abstract Long payeeId();

  @ColumnName(KEY_TRANSFER_ACCOUNT)
  @Nullable
  abstract Long transferAccount();

  @ColumnName(KEY_METHODID)
  @Nullable
  abstract Long methodId();

  @ColumnName(KEY_CR_STATUS)
  @Nullable
  abstract String crStatus();

  @ColumnName(KEY_REFERENCE_NUMBER)
  @Nullable
  abstract String referenceNumber();

  @ColumnName(KEY_PICTURE_URI)
  @Nullable
  abstract String pictureUri();

  public enum Type {
    created, updated, deleted;

    public static final String JOIN;
    static {
      JOIN = TextUtils.joinEnum(Type.class);
    }
  }

  public boolean isCreate() {
    return type().equals(Type.created.name());
  }

  public boolean isUpdate() {
    return type().equals(Type.updated.name());
  }

  public boolean isDelete() {
    return type().equals(Type.deleted.name());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public Builder setType(Type type) {
      return setType(type.name());
    }
    public abstract Builder setType(String value);
    public abstract Builder setUuid(String value);
    public abstract Builder setParentUuid(String value);
    public abstract Builder setComment(String value);
    public abstract Builder setAmount(Long value);
    public abstract Builder setDate(Long value);
    public abstract Builder setCatId(Long value);
    public abstract Builder setPayeeId(Long value);
    public abstract Builder setTransferAccount(Long value);
    public abstract Builder setMethodId(Long value);
    public abstract Builder setCrStatus(String value);
    public abstract Builder setReferenceNumber(String value);
    public abstract Builder setPictureUri(String value);
    public abstract TransactionChange build();
  }
}