package org.totschnig.myexpenses.test.provider;

import android.content.ContentValues;

import org.totschnig.myexpenses.util.Utils;

import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_PAYEE_NAME;
import static org.totschnig.myexpenses.provider.DatabaseConstants.KEY_PAYEE_NAME_NORMALIZED;

public class PayeeInfo {
  public PayeeInfo(String name) {
    this.name = name;
  }

  String name;

  ContentValues getContentValues() {
    ContentValues contentValues = new ContentValues(2);
    contentValues.put(KEY_PAYEE_NAME, name);
    contentValues.put(KEY_PAYEE_NAME_NORMALIZED, Utils.normalize(name));
    return contentValues;
  }
}
