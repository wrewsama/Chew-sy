import { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import DataService from '../api/api'
import NotFound from './not-found'
import Restaurant from './restaurant'

export default function Session() {
	const { id } = useParams()
	const [restaurants, setRestaurants] = useState([])
	const [found, setFound] = useState(true)

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

	useEffect(() => {
		checkSessionExists()
		getAllRestaurants()
	}, [])

	return (
		<div className='container'>
			{
				found && (
					<ul className='list-group'>
						{
							restaurants.map(restaurant => {
								return <Restaurant key={restaurant.id}
								                   restaurant={restaurant} />
							})
						}
					</ul>
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
