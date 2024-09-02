import PostList from "../components/community/PostList";
import style from './styles/Community.module.css';

const CommunityPage = () => {
    return (
        <div className={style.container}>
          <PostList />
        </div>
    );
};

export default CommunityPage;