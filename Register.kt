package com.example.kotlindemonew.Activity

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.StrictMode
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.example.kotlindemonew.R
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.*
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.karumi.dexter.listener.single.PermissionListener
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File
import java.io.IOException

class Register:AppCompatActivity() {
    @BindView(R.id.name)lateinit var name: TextInputEditText
    @BindView(R.id.email)lateinit var email:TextInputEditText
    @BindView(R.id.mobile)lateinit var mobile:TextInputEditText
    @BindView(R.id.password)lateinit var password:TextInputEditText
    @BindView(R.id.btn_submit)lateinit var btn_submit: Button
    @BindView(R.id.profile_image)lateinit var profile_image: CircleImageView
    private val TAKE_PHOTO_REQUEST = 101
    private val CAMERA_IMAGE = 102
    private var mCurrentPhotoPath: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        ButterKnife.bind(this)
        profile_image.setOnClickListener {
            validatePermissions()
        }
        btn_submit.setOnClickListener {
      if(name?.text.isNullOrEmpty()){
          name?.error ="Please Enter Your Name."
      }else if(mobile?.text.isNullOrEmpty()){
          mobile?.error="Please Enter Your Mobile"
      }else if(email?.text.isNullOrEmpty()){
          email?.error="Please Enter your Email"
      }else if(password?.text.isNullOrEmpty()){
          password?.error="Please Enter your Password"
      }else{
          Toast.makeText(this@Register,"Register Succefully",Toast.LENGTH_LONG );
      }
      }
  }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == CAMERA_IMAGE) {
            var f2 = File(Environment.getExternalStorageDirectory().toString())
            Log.d("mytag", "f" + f2.absoluteFile + " " + f2.parentFile)
            for (temp in f2.listFiles()) {
                if (temp.name == "temph.jpg") {
                    f2 = temp
                    Log.d("mytag", "f2=temph "+ f2.toString())
                    break
                }
            }
            try {
                profile_image.setImageBitmap(MediaStore.Images.Media.getBitmap(contentResolver, Uri.fromFile(f2)))
            } catch (e: IOException) {
                e.printStackTrace()
            }

            //Log.d("mytag", "loan_img1file $f2")
//                    loan_img2file= f2;
            //  val  myBitmap:Bitmap
//            myBitmap   = BitmapFactory.decodeFile(f2.getAbsolutePath());
//            profile_image.setImageBitmap(myBitmap)

           // Picasso.with(this@Register).load(f2.path).into(profile_image);
           // profile_image.setImageBitmap(data?.extras?.get("data") as Bitmap)

//            Picasso.with(this)
//                .load(artistImageUrl)
//                .into(new Target() {
//                    @Override
//                    public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
//                        /* Save the bitmap or do something with it here */
//
//                        // Set it in the ImageView
//                        theView.setImageBitmap(bitmap)
//                    }
//
//                    @Override
//                    public void onBitmapFailed(Drawable errorDrawable) {
//
//                    }
//
//                    @Override
//                    public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//                    }
//                });

//            val imageUri: Uri
//            val bitmap: Bitmap
//            imageUri = data!!.getData()
//             bitmap = MediaStore . Images . Media . getBitmap (this.getContentResolver(), imageUri);

//           Log.d("mytag","imageurl "+imageUri)
//           Log.d("mytag","bitmap "+bitmap)

             //processCapturedPhoto()
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun select_Cheque1() {
        val options = arrayOf<CharSequence>("Take Photo")

        val builder = android.app.AlertDialog.Builder(this@Register)
        builder.setItems(options) { dialog, item ->
            if (options[item] == "Take Photo") {
                if (applicationContext.packageManager.hasSystemFeature(
                        PackageManager.FEATURE_CAMERA
                    )
                ) {
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    val f = File(Environment.getExternalStorageDirectory(), "temph.jpg")
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f))
                    val builder = StrictMode.VmPolicy.Builder()
                    StrictMode.setVmPolicy(builder.build())
                    startActivityForResult(intent, CAMERA_IMAGE)
                    // Open default camera
                    //                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //                        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                    //
                    //                        // start the image capture Intent
                    //                        startActivityForResult(intent, CAMERA_IMAGE14);

                } else {
                    Toast.makeText(applicationContext, "Camera not supported", Toast.LENGTH_LONG).show()
                }
            }
        }
        builder.show()
    }

    private fun validatePermissions() {
//          Dexter.withActivity(this)
//                .withPermissions(
//                        Manifest.permission.READ_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.ACCESS_FINE_LOCATION)
//                .withListener(object:MultiplePermissionsListener {
//                    @Override fun onPermissionsChecked( report: MultiplePermissionsReport) {
//                        // check if all permissions are granted
//                        if (report.areAllPermissionsGranted()) {
//                            Toast.makeText(getApplicationContext(), "All permissions are granted!", Toast.LENGTH_SHORT).show();
//                        }
//
//                        // check for permanent denial of any permission
//                        if (report.isAnyPermissionPermanentlyDenied()) {
//                            // show alert dialog navigating to Settings
//                            showSettingsDialog();
//                        }
//                    }
//
//                    @Override fun onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
//                        token.continuePermissionRequest();
//                    }
//                }).
//                withErrorListener(object : PermissionRequestErrorListener {
//                    @Override fun onError(error:DexterError) {
//                        Toast.makeText(getApplicationContext(), "Error occurred! ", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .onSameThread()
//                .check();


        Dexter.withActivity(this)
            .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)

            .withListener(object: PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                    //launchCamera()
                    select_Cheque1()
                }
                override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest?,
                                                                token: PermissionToken?) {
                    AlertDialog.Builder(this@Register)
                        .setTitle("Permisstion")
                        .setMessage("Please Allow Permistion")
                        .setNegativeButton(android.R.string.cancel,
                            { dialog, _ ->
                                dialog.dismiss()
                                token?.cancelPermissionRequest()
                            })
                        .setPositiveButton(android.R.string.ok,
                            { dialog, _ ->
                                dialog.dismiss()
                                token?.continuePermissionRequest()
                            })
                        .setOnDismissListener({ token?.cancelPermissionRequest() })
                        .show()
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                    Toast.makeText(this@Register,"denied",Toast.LENGTH_LONG).show()
//                    Snackbar.make(this@Register,
//                        R.string.storage_permission_denied_message,
//                        Snackbar.LENGTH_LONG)
//                        .show()
                }
            })
            .check()


    }

    private fun launchCamera() {
        val values = ContentValues(1)
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpg")
        val fileUri = contentResolver
            .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                values)
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(intent.resolveActivity(packageManager) != null) {
            mCurrentPhotoPath = fileUri.toString()
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION
                    or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            startActivityForResult(intent, TAKE_PHOTO_REQUEST)
        }
    }


    private fun processCapturedPhoto() {
        val cursor = contentResolver.query(
            Uri.parse(mCurrentPhotoPath),
            Array(1) {android.provider.MediaStore.Images.ImageColumns.DATA},
            null, null, null)
        cursor.moveToFirst()
        val photoPath = cursor.getString(0)
        cursor.close()
        val file = File(photoPath)
        val uri = Uri.fromFile(file)
        Log.d("mytag","file "+file);

        try {
            profile_image.setImageBitmap(MediaStore.Images.Media.getBitmap(contentResolver, Uri.fromFile(file)))
        } catch (e: IOException) {
            e.printStackTrace()
        }

//        val height = resources.getDimensionPixelSize(R.dimen.photo_height)
//        val width = resources.getDimensionPixelSize(R.dimen.photo_width)

//        val request = ImageRequestBuilder.newBuilderWithSource(uri)
//            .setResizeOptions(ResizeOptions(width, height))
//            .build()
//        val controller = Fresco.newDraweeControllerBuilder()
//            .setOldController(profile_image?.controller)
//            .setImageRequest(request)
//            .build()
//        profile_image?.controller = controller
    }

}