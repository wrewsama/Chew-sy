import { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'

export default function Session() {
	const { id } = useParams()
	const [restaurants, setRestaurants] = useState([])

	const checkSessionExists = () => {}

	const getAllRestaurants = () => {}

	useEffect(() => {
		console.log(id)
	}, [])

	return (
		<div className='container'>
			hi
		</div>
	)
}
