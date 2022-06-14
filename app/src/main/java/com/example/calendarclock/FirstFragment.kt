package com.example.calendarclock

import android.content.ContentResolver
import android.content.ContentUris
import android.content.Intent
import android.database.Cursor
import android.icu.util.Calendar
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.calendarclock.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Run query
        // TODO remove filters, figure out contentResolver
        val uri: Uri = CalendarContract.Calendars.CONTENT_URI
        val selection: String = "((${CalendarContract.Calendars.ACCOUNT_TYPE} = ?) AND (" +
                "${CalendarContract.Calendars.OWNER_ACCOUNT} = ?))"
        val selectionArgs: Array<String> = arrayOf("hera@example.com", "com.example", "hera@example.com")
        val cur: Cursor = contentResolver.query(uri, EVENT_PROJECTION, selection, selectionArgs, null)

//        // TODO querying events
//        val startMillis: Long = Calendar.getInstance().run {
//            set(2011, 9, 23, 8, 0)
//            timeInMillis
//        }
//        val endMillis: Long = Calendar.getInstance().run {
//            set(2011, 10, 24, 8, 0)
//            timeInMillis
//        }
//
//        super.onViewCreated(view, savedInstanceState)
//        val builder: Uri.Builder = CalendarContract.CONTENT_URI.buildUpon()
//            .appendPath("time")
//        ContentUris.appendId(builder, startMillis)
//        val intent = Intent(Intent.ACTION_VIEW)
//            .setData(builder.build())
//        startActivity(intent)
        // binding.buttonFirst.setOnClickListener
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}