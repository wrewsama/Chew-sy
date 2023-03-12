import { Link } from 'react-router-dom'

export default function NotFound() {
	return (
		<div className="d-flex align-items-center justify-content-center">
			<div className="text-center">
				<h1 className="display-1 fw-bold">404 </h1>
				<p className="fs-3">
					<span className="text-danger"> Oops! </span>
					This session doesn't exist.
				</p>
				<Link to='/'>
					<button className='btn btn-light'>
						Create a Session
					</button>
				</Link>
			</div>
		</div>
	)
}
