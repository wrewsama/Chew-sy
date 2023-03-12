import { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { v4 as uuidv4 } from 'uuid'
import DataService from '../api/api'
import NotFound from './not-found'
import Restaurant from './restaurant'
import RandomSelector from './random-selector'

export default function Session() {
	const { id } = useParams()
	const [restaurants, setRestaurants] = useState([])
	const [found, setFound] = useState(true)
	const [newRestaurantName, setNewRestaurantName] = useState('')
	const [sessionName, setSessionName] = useState('')
	const [copied, setCopied] = useState(false)
	const BASEURL = 'localhost:5173/'

	const checkSessionExists = () => {
		DataService.getSession(id)
			.then(res => {
				setFound(true)
				setSessionName(res.data.body.name)
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

				// clear input field
				setNewRestaurantName('')
			})
			.catch(e => {
				console.error(e)
			})
	}

	const handleCopyButtonClick = async event => {
		await navigator.clipboard.writeText(BASEURL + id)
		setCopied(true)
	}

	useEffect(() => {
		checkSessionExists()
		getAllRestaurants()
	}, [])

	return (
		<div className='container'>
			<div className='container text-center mb-5'>
				<h3> {sessionName}'s session </h3>
				<p> 
					Add some restaurants to get started.
					Share this link to let others suggest some restaurants:
				</p>
				<p>
					{BASEURL + id}
				</p>
				<button className='btn btn-light'
				        onClick={handleCopyButtonClick}>
					Copy Link
				</button>
				{
					copied && (
						<span className='fw-light'> Link Copied! </span>
					)
				}
			</div>
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
					<RandomSelector />
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
