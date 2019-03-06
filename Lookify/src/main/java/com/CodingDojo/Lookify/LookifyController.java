package com.CodingDojo.Lookify;

import java.util.List;
//import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.CodingDojo.Lookify.models.Song;
import com.CodingDojo.Lookify.services.SongService;



@Controller
public class LookifyController {
	private final SongService sS;
	
	public LookifyController(SongService songService) {
		this.sS = songService;
	}
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/dash")
	public String dash(Model model) {
		List<Song> songs = sS.allSongs();
		model.addAttribute("songs", songs);
		return "dash.jsp";
	}
	//Add song
	@PostMapping("/submit")
	public String createSong(@Valid @ModelAttribute("newSong") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		} else {
			System.out.println(song.getTitle());
			sS.createSong(song);
			System.out.println(song.getTitle());
			return "redirect:/dash";
		}
	}
	
	@GetMapping("/songs")
	public String songs(@ModelAttribute("newSong") Song song) {
		return "add.jsp";
	}
	
	@GetMapping("/top")
	public String topTen(Model model) {
		List<Song> song = sS.sortedSongs();
		model.addAttribute("banana", song);
		return "top.jsp";
	}
	
	@PostMapping("/search")
	public String find(@RequestParam(value="findme") String result, Model model) {
		if(result == null) {
			return "dash.jsp";
		}
		List<Song> artist = sS.searchByArtist(result);
		model.addAttribute("brujas", artist);
		List<Song> song = sS.searchByTitle(result);
		model.addAttribute("cantares", song);
		return "results.jsp";
	}
	//Updates song
	@RequestMapping(value="/songs/edit/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			sS.updateSong(song);
			return "redirect:/dash";
		}
	}
	
	// Shows song
	@GetMapping("/songs/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Song song = sS.findSong(id);
		model.addAttribute("song", song);
		return "show.jsp";
	}
	@RequestMapping(value="/songs/delete/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		sS.deleteSong(id);
		System.out.println("Deleted song with id"+id);
		return "redirect:/dash";
	}
	
}