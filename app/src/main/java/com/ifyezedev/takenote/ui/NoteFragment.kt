package com.ifyezedev.takenote.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ifyezedev.takenote.R
import com.ifyezedev.takenote.databinding.FragmentNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : Fragment() {
    lateinit var binding: FragmentNoteBinding

    //because we used the @HiltViewModel on our view models we can just call them like this
    //in our fragment/activity and hilt knows how to instantiate them
    val noteViewModel by viewModels<NoteViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_note, container, false)

        setHasOptionsMenu(true)

        noteViewModel.readyToNavigate.observe(viewLifecycleOwner, Observer {readyToNavigate: Boolean ->
            if (readyToNavigate){
                this.findNavController().navigate(NoteFragmentDirections.actionNoteFragmentToHomeFragment())
            }
        })

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.note_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.save -> saveNote()
            R.id.share ->shareNote()
            R.id.delete ->deleteNote()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun deleteNote() {
        TODO("Not yet implemented")
    }

    private fun shareNote() {
        TODO("Not yet implemented")
    }

    private fun saveNote() {
        Log.i("NoteFragment", "in save note -F")
        val title = binding.noteTitleEditText.editableText.toString()
        val content =binding.noteContentEditText.editableText.toString()

        noteViewModel.saveNote(null, title, content)
    }
}