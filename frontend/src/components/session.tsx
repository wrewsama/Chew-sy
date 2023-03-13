import { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { v4 as uuidv4 } from 'uuid'
import DataService from '../api/api'
import NotFound from './not-found'
import Restaurant from './restaurant'
import RandomSelector from './random-selector'

interface Rest {
	id: String;
	sessionId: String;
	name: String;
}

export default function Session() {
	const { id } = useParams()
	const [restaurants, setRestaurants] = useState<Rest[]>([])
	const [found, setFound] = useState(true)
	const [newRestaurantName, setNewRestaurantName] = useState('')
	const [sessionName, setSessionName] = useState('')
	const [copied, setCopied] = useState(false)
	const URL:string = window.location.href 

	const checkSessionExists = () => {
		DataService.getSession(id as string)
			.then(res => {
				setFound(true)
				setSessionName(res.data.body.name)
			})
			.catch(e => {
				setFound(false)
			})
	}


	const getAllRestaurants = () => {
		DataService.getAllRestaurants(id as string)
			.then(res => {
				setRestaurants(res.data.body)
			})
			.catch(e => {
				console.error(e)
			})
	}

	const handleNameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
		setNewRestaurantName(event.target.value)	
	}

	const saveRestaurant = () => {
		const newRestaurant = {
			id: uuidv4(),
			sessionId: id as string,
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

	const handleKeyPress = (event: React.KeyboardEvent<HTMLInputElement>) => {
		if (event.code === 'Enter' && newRestaurantName !== '') {
			saveRestaurant()
		}
	}

	const handleAddButtonClick:React.MouseEventHandler<HTMLElement> = (event) => {
		saveRestaurant()
	}

	const handleCopyButtonClick:React.MouseEventHandler<HTMLElement> = async (event) => {
		await navigator.clipboard.writeText(URL)
		setCopied(true)
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
					<div className='container text-center mb-5'>
						<h3> {sessionName}'s session </h3>
						<p> 
							Add some restaurants to get started.
							Share this link to let others suggest some restaurants:
						</p>
						<p>
							{URL}
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

					<ul className='list-group'>
						{
							restaurants.map(restaurant => {
								return <Restaurant key={restaurant.id as string}
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
							   onKeyDown={handleKeyPress}
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
