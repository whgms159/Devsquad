import React, { useState, useEffect } from 'react';
import style from './styles/PostList.module.css';

interface Post {
  id: number;
  title: string;
  author: string;
  date: string;
  content: string;
}

// 개별 게시물 항목 컴포넌트
const PostItem: React.FC<Post> = ({ title, author, date, content }) => (
  <div className={style.postItem}>
    <h5 className={style.postTitle}>{title}</h5>
    <p className={style.postMeta}>{author} | {date}</p>
    <p className={style.postContent}>{content.slice(0, 100)}...</p>
  </div>
);

export default function PostList() {
  const [posts, setPosts] = useState<Post[]>([]);

  useEffect(() => {
    // 데이터를 API에서 가져오는 부분

    // 예시로 하드코딩된 데이터
    const fetchPosts = async () => {
      // 예시 데이터
      const examplePosts: Post[] = [
        { id: 1, title: '첫 번째 게시물', author: '작성자1', date: '2024-09-01', content: '게시물 내용' },
        { id: 2, title: '두 번째 게시물', author: '작성자2', date: '2024-09-02', content: '게시물 내용' },
      ];
      setPosts(examplePosts);
    };

    fetchPosts();
  }, []);

  return (
    <div className={style.postListContainer}>
      <h4 className={style.header}>게시글</h4>
      <div className={style.postList}>
        {posts.map(post => (
          <PostItem 
            key={post.id}
            id={post.id}
            title={post.title} 
            author={post.author} 
            date={post.date} 
            content={post.content} 
          />
        ))}
      </div>
    </div>
  );
}
