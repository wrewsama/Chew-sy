import axios from 'axios'

const http = axios.create({
	baseURL: "https://chewsy-backend.onrender.com",
	headers: {
		"Content-type": "application/json;charset=UTF-8",
		"Access-Control-Allow-Origin": "*",
	}
})

type Session = {
	id: String;
	name: String;
}

type Restaurant = {
	id: String;
	sessionId: String;
	name: String;
}


export default class DataService {
	static addSession(data:Session) {
		return http.post("/sessions", data)
	}

	static getSession(id:String) {
		return http.get(`/sessions/${id}`)
	}

	static getAllRestaurants(id:String) {
		return http.get(`/restaurants/${id}`)
	}

	static getRandomRestaurant(id:String) {
		return http.get(`/restaurants/random/${id}`)
	}

	static addRestaurant(data:Restaurant) {
		return http.post("/restaurants", data)
	}

	static deleteRestaurant(id:String) {
		return http.delete(`/restaurants/${id}`)
	}
}
