import { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { v4 as uuidv4 } from 'uuid'
import DataService from '../api/api'
import NotFound from './not-found'
import Restaurant from './restaurant'

export default function Session() {
	const { id } = useParams()
	const [restaurants, setRestaurants] = useState([])
	const [found, setFound] = useState(true)
	const [newRestaurantName, setNewRestaurantName] = useState('')

	const checkSessionExists = () => {
		DataService.getSession(id)
			.then(res => {
				setFound(true)
			})
			.catch(e => {
				setFound(false)
			})
	}


	const getAllRestaurants = () => {
		DataService.getAllRestaurants(id)
			.then(res => {
				setRestaurants(res.data.body)
			})
			.catch(e => {
				console.error(e)
			})
	}

	const handleNameChange = event => {
		setNewRestaurantName(event.target.value)	
	}

	const handleAddButtonClick = event => {
		const newRestaurant = {
			id: uuidv4(),
			sessionId: id,
			name: newRestaurantName
		}
		DataService.addRestaurant(newRestaurant)
			.then(res => {
				// update the list of resturants
				getAllRestaurants()
			})
			.catch(e => {
				console.error(e)
			})
	}

	useEffect(() => {
		checkSessionExists()
		getAllRestaurants()
	}, [])

	return (
		<div className='container'>
			{
				found && (
					<>
					<ul className='list-group'>
						{
							restaurants.map(restaurant => {
								return <Restaurant key={restaurant.id}
								                   restaurant={restaurant}
												   callback={getAllRestaurants}/>
							})
						}
					</ul>

					<div className='input-group mb-3'>
						<input type='text'
						       className='form-control'
							   placeholder='Suggest a restaurant'
							   onChange={handleNameChange}
							   value={newRestaurantName} />

						<button className='btn btn-outline-primary'
						        type='button'
								onClick={handleAddButtonClick}>
							+
						</button>
					</div>
					</>
				)
			}
			{
				found || (
					<NotFound />
				)
			}
		</div>
	)
}
