package com.example.kotlindemonew.Activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kotlindemonew.R
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONException
import org.json.JSONObject

class QRCodeActivity:AppCompatActivity() {
    @BindView(R.id.name) internal  lateinit var txtName:TextView
    @BindView(R.id.site_name)internal lateinit var txtSiteName: TextView
    @BindView(R.id.btnScan)internal lateinit var btnScan: Button
    @BindView(R.id.showQRScanner)internal lateinit var showQRScanner: Button
    internal var qrScanIntegrator: IntentIntegrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode);
        ButterKnife.bind(this@QRCodeActivity)
        qrScanIntegrator = IntentIntegrator(this)

        btnScan?.setOnClickListener {
            performAction()
        }
        showQRScanner.setOnClickListener {

        }
        showQRScanner.setOnClickListener {
            run {
                IntentIntegrator(this@QRCodeActivity).initiateScan();
            }
        }

    }

    private fun performAction() {
        qrScanIntegrator?.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            // If QRCode has no data.
            if (result.contents == null) {
                Toast.makeText(this@QRCodeActivity, "result_not_found", Toast.LENGTH_LONG).show()
            } else {
                // If QRCode contains data.
                try {
                    // Converting the data to json format
                    val obj = JSONObject(result.contents)

                    // Show values in UI.
                    txtName?.text = result.contents
                    txtSiteName?.text = obj.getString("site_name")

                } catch (e: JSONException) {
                    e.printStackTrace()

                    // Data not in the expected format. So, whole object as toast message.
                    Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}