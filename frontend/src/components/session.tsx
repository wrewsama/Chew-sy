import { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import DataService from '../api/api'
import NotFound from './not-found'

export default function Session() {
	const { id } = useParams()
	const [restaurants, setRestaurants] = useState([])
	const [found, setFound] = useState(true)

	const checkSessionExists = () => {
		DataService.getSession()
			.then(res => {
				setFound(true)
			})
			.catch(e => {
				setFound(false)
			})
	}


	const getAllRestaurants = () => {}

	useEffect(() => {
		checkSessionExists()
	}, [])

	return (
		<div className='container'>
			{
				found || (
					<NotFound />
				)
			}
		</div>
	)
}
