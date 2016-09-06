package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.BuildDAO;
import data.Deck;
import data.Wheel;
import data.Bearing;
import data.Truck;

@Controller
@SessionAttributes("allDecks")
public class BuildController {

	@Autowired
	private BuildDAO buildDAO;

	@ModelAttribute("decks")
	public List<Deck> initDecks() {
		List<Deck> deckList = buildDAO.ListAllDecks();
		return deckList;
	}

	@ModelAttribute("wheels")
	public List<Wheel> initWheels() {
		List<Wheel> wheelList = buildDAO.getAllWheels();
		return wheelList;
	}

	@ModelAttribute("bearings")
	public List<Bearing> initBearings() {
		List<Bearing> bearingList = buildDAO.getAllBearings();
		return bearingList;
	}

	@ModelAttribute("trucks")
	public List<Truck> initTrucks() {
		List<Truck> truckList = buildDAO.getAllTrucks();
		return truckList;
	}

//	@RequestMapping(path = "GetDeckBrand.do", method = RequestMethod.GET)
//	public ModelAndView getByBrand(@RequestParam("deckBrand") String b) {
//		ModelAndView mv = new ModelAndView("results.jsp");
//		mv.addObject("decksByBrand", buildDAO.getDecksByBrand(b));
//		return mv;
//	}
	@RequestMapping(path = "GetDeckURL.do", method = RequestMethod.GET)
	public ModelAndView getByURL(@RequestParam("url") String b) {
		ModelAndView mv = new ModelAndView("results.jsp");
		mv.addObject("decksByURL", buildDAO.getDecksByBrand(b));
		return mv;
	}

	@RequestMapping(path = "GetDeckName.do", method = RequestMethod.POST)
	public ModelAndView returnByName(@RequestParam("deckName") String n) {
		ModelAndView mv = new ModelAndView("results.jsp");
		mv.addObject("deck", buildDAO.getDeckByName(n));
		return mv;
	}
	// @RequestMapping(path = "AddDeck.do", method = RequestMethod.POST)
	// public ModelAndView newDeckName(@RequestParam("customName") String cn) {
	//
	// buildDAO.addDeck(Deck deck);
	// ModelAndView mv = new ModelAndView("addDeck.jsp");
	// mv.addObject("newDeck", buildDAO.getDeck());
	// return mv;
	// }

//	@RequestMapping(path = "NewDeck.do", method = RequestMethod.POST)
//	public ModelAndView newDeck(Deck deck) {
//		buildDAO.addDeck(deck);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("results.jsp");
//		return mv;
//	}

	@RequestMapping(path = "GetWheelBrand.do", method = RequestMethod.POST)
	public ModelAndView wheelsByBrand(@RequestParam("wheelBrand") String b) {
		ModelAndView mv = new ModelAndView("results.jsp");
		mv.addObject("wheel", buildDAO.getWheelsByBrand(b));
		return mv;
	}

	@RequestMapping(path = "GetWheelRank.do", method = RequestMethod.GET)
	public ModelAndView wheelsByRank(@RequestParam("wheelRank") String r) {
		ModelAndView mv = new ModelAndView("wheel.jsp");
		mv.addObject("wheelsByRank", buildDAO.getWheelsByRank(r));
		return mv;
	}

	@RequestMapping(path = "NewWheel.do", method = RequestMethod.POST)
	public ModelAndView newWheel(Wheel wheel) {
		buildDAO.addWheel(wheel);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		return mv;
	}

	@RequestMapping(path = "GetBearingBrand.do", method = RequestMethod.POST)
	public ModelAndView bearingsByBrand(@RequestParam("bearingBrand") String b) {
		ModelAndView mv = new ModelAndView("results.jsp");
		mv.addObject("bearing", buildDAO.getBearingsByBrand(b));
		return mv;
	}

	@RequestMapping(path = "GetBearingRank.do", method = RequestMethod.GET)
	public ModelAndView bearingsByRank(@RequestParam("bearingRank") String r) {
		ModelAndView mv = new ModelAndView("bearing.jsp");
		mv.addObject("bearingsByRank", buildDAO.getBearingsByRank(r));
		return mv;
	}

	@RequestMapping(path = "NewBearing.do", method = RequestMethod.POST)
	public ModelAndView newBearing(Bearing bearing) {
		buildDAO.addBearing(bearing);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		return mv;
	}

	@RequestMapping(path = "GetTruckBrand.do", method = RequestMethod.POST)
	public ModelAndView trucksByBrand(@RequestParam("truckBrand") String b) {
		ModelAndView mv = new ModelAndView("results.jsp");
		mv.addObject("truck", buildDAO.getTrucksByBrand(b));
		return mv;
	}

	@RequestMapping(path = "GetTruckRank.do", method = RequestMethod.GET)
	public ModelAndView trucksByRank(@RequestParam("truckRank") String r) {
		ModelAndView mv = new ModelAndView("truck.jsp");
		mv.addObject("trucksByRank", buildDAO.getTrucksByRank(r));
		return mv;
	}

	@RequestMapping(path = "NewTrucks.do", method = RequestMethod.POST)
	public ModelAndView newTruck(Truck truck) {
		buildDAO.addTruck(truck);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("results.jsp");
		return mv;
	}

	@RequestMapping(path = "GoToBuildJSP.do", method = RequestMethod.GET)
	public ModelAndView goToBuild(@RequestParam("deckBrand") String db, @RequestParam("wheelRank") String wr,
			@RequestParam("bearingRank") String br, @RequestParam("truckRank") String tr) {
		ModelAndView mv = new ModelAndView("buildBoard.jsp");
		mv.addObject("decksByBrand", buildDAO.getDecksByBrand(db));
		mv.addObject("wheelsByRank", buildDAO.getWheelsByRank(wr));
		mv.addObject("bearingsByRank", buildDAO.getBearingsByRank(br));
		mv.addObject("trucksByRank", buildDAO.getTrucksByRank(tr));
		return mv;
	}

	@RequestMapping(path = "GoToResultsJSP.do", method = RequestMethod.POST)
	public ModelAndView goToResults(@RequestParam("deckName") String du, @RequestParam("wheelBrand") String wb,
			@RequestParam("bearingBrand") String bb, @RequestParam("truckBrand") String tb) {
		ModelAndView mv = new ModelAndView("results.jsp");
		mv.addObject("deck", buildDAO.getDeckByName(du));
		mv.addObject("wheel", buildDAO.getWheelsByBrand(wb));
		mv.addObject("bearing", buildDAO.getBearingsByBrand(bb));
		mv.addObject("truck", buildDAO.getTrucksByBrand(tb));
		return mv;
	}

	@RequestMapping(path = "addNewSetup.do", method = RequestMethod.POST)
	public ModelAndView addCustomSetup(Deck deck,Wheel wheel, Bearing bearing, Truck truck){
		buildDAO.addDeck(deck);
		buildDAO.addWheel(wheel);
		buildDAO.addBearing(bearing);
		buildDAO.addTruck(truck);
		ModelAndView mv = new ModelAndView("results.jsp");
		mv.addObject("decks",buildDAO.ListAllDecks());
	
		return mv;
	}

	@RequestMapping(path = "GoToViewAll.do", method = RequestMethod.GET)
	public ModelAndView goToViewAll() {
		ModelAndView mv = new ModelAndView("viewAll.jsp");
		mv.addObject("decks", buildDAO.ListAllDecks());
	
		return mv;
	}
	
	@RequestMapping(path = "removeSetup.do")
	public ModelAndView removeSetup(Deck deck,Wheel wheel, Bearing bearing, Truck truck){
		buildDAO.removeDeck(deck);
		buildDAO.removeWheel(wheel);
		buildDAO.removeBearing(bearing);
		buildDAO.removeTruck(truck);
		ModelAndView mv = new ModelAndView("removeSetup.jsp");
		mv.addObject("decks",buildDAO.ListAllDecks());
	
		return mv;
	}
	@RequestMapping(path = "removeSetupFromList.do")
	public ModelAndView removeSetupFromList(@RequestParam("deckName") String dn, @RequestParam("wheelBrand") String wb,
			@RequestParam("bearingBrand") String bb, @RequestParam("truckBrand") String tb){
		buildDAO.removeDeck(buildDAO.getDeckByName(dn));
		buildDAO.removeWheel(buildDAO.getWheelsByBrand(wb));
		buildDAO.removeBearing(buildDAO.getBearingsByBrand(bb));
		buildDAO.removeTruck(buildDAO.getTrucksByBrand(tb));
		ModelAndView mv = new ModelAndView("results.jsp");
		mv.addObject("decks",buildDAO.ListAllDecks());
	
		return mv;
	}
	

	@RequestMapping("goToEditSetup.do")
	public ModelAndView goToChangeName() {
		ModelAndView mv = new ModelAndView("EditSetup.jsp");
		mv.addObject("decks",buildDAO.ListAllDecks());
		mv.addObject("wheels",buildDAO.getAllWheels());
		mv.addObject("bearings",buildDAO.getAllBearings());
		mv.addObject("trucks",buildDAO.getAllTrucks());
	
		return mv;
	}
	
	@RequestMapping(path = "editSetup.do", method = RequestMethod.POST)
	public ModelAndView editSetup(@RequestParam("deckName") String pdn,
			@RequestParam("wheelBrand") String pwb,
			@RequestParam("bearingBrand") String pbb, 
			@RequestParam("truckBrand") String ptb,@RequestParam("newDeckName") String ndn,
			@RequestParam("newWheelBrand") String nwb,@RequestParam("newBearingBrand") String nbb, 
			@RequestParam("newTruckBrand") String ntb){
	
		Deck prevdn = buildDAO.getDeckByName(pdn);
		Wheel prevwb = buildDAO.getWheelsByBrand(pwb);
		Bearing prevbb = buildDAO.getBearingsByBrand(pbb);
		Truck prevtb = buildDAO.getTrucksByBrand(ptb);
		
		prevdn.setDeckName(ndn);
		prevwb.setWheelBrand(nwb);
		prevbb.setBearingBrand(nbb);
		prevtb.setTruckBrand(ntb);
		ModelAndView mv = new ModelAndView("results.jsp");
		mv.addObject("decks",buildDAO.ListAllDecks());
		mv.addObject("wheels",buildDAO.getAllWheels());
		mv.addObject("bearings",buildDAO.getAllBearings());
		mv.addObject("trucks",buildDAO.getAllTrucks());
		
		return mv;
	}

	
}
